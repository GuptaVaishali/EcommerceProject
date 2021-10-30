package com.ttn.project.ecommerce.controllers;

import com.ttn.project.ecommerce.entities.Customer;
import com.ttn.project.ecommerce.entities.Token;
import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.repos.TokenRepository;
import com.ttn.project.ecommerce.repos.UserRepository;
import com.ttn.project.ecommerce.services.CustomerDaoService;
import com.ttn.project.ecommerce.services.EmailSenderService;
import com.ttn.project.ecommerce.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerDaoService customerDaoService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    TokenService tokenService;

    @GetMapping("/customerusers")
    public List<Customer> retrieveAllCustomers() {
        return customerDaoService.readAllCustomers();
    }

//    // creating and returning same user
//    @PostMapping("/customerusers")
//    public Customer createCustomer(@RequestBody Customer customer){
//        System.out.println(customer.getFirstName());
//        Customer savedCustomer = customerDaoService.createCustomerUser(customer);
//        return savedCustomer;
//    }

    //  creating employee and send response status created 201.
    @PostMapping("/register-customer")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Customer customer){
        Customer savedCustomer = customerDaoService.createCustomerUser(customer);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customer.getEmail());
        mailMessage.setSubject("Customer Activated");
        mailMessage.setFrom("vaishgupta97@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:8080/confirm-customer?token="+tokenService.createToken(customer).getToken());

        emailSenderService.sendEmail(mailMessage);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(savedCustomer.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @PutMapping("/confirm-customer")
    public String confirmUserAccount(@RequestParam("token") String token)
    {
        Token cToken = tokenRepository.findByToken(token);
        if(cToken != null)
        {
            LocalDateTime now = LocalDateTime.now();
            if(ChronoUnit.SECONDS.between(now, cToken.getExpireAt()) <= 0){
                //    cToken.setExpired(true);
                Token newToken = tokenService.generateNewToken(cToken);
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(cToken.getUser().getEmail());
                mailMessage.setSubject("Customer Activated");
                mailMessage.setFrom("vaishgupta97@gmail.com");
                mailMessage.setText("To confirm your account, please click here : "
                        +"http://localhost:8080/confirm-customer?token="+ newToken.getToken());

                emailSenderService.sendEmail(mailMessage);
                tokenRepository.delete(cToken);
                return "Another mail has been sent for activation";
            }
            else {
                System.out.println("else part activation ka");
                User user = userRepository.findByEmail(cToken.getUser().getEmail());
                System.out.println("else part activation ka part1");
                user.setActive(true);
                userRepository.save(user);

                System.out.println("Deleted token");
                tokenRepository.delete(cToken);

                return "Customer Activated Successfully";
            }

        }
        return "Customer Not Active.";
    }


    @PostMapping("/resend-link")
    public String resendLink(@Valid @RequestParam String email){
        User userInDb = userRepository.findByEmail(email);
        System.out.println(">>>>>>>>" + userInDb.getEmail());
        if (userInDb != null){
        //    System.out.println(">>>>>>>>>>>Again Printing" + userInDb.getEmail());
            Token token = tokenRepository.findByEmail(email);
        //    System.out.println(">>>>>>>>>printing token >>> " + token.getToken());
            tokenRepository.delete(token);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email);
            mailMessage.setSubject("Re-Send Activation link for customer");
            mailMessage.setFrom("vaishgupta97@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-customer?token=" +
                    customerDaoService.generateReToken(email).getToken());

            emailSenderService.sendEmail(mailMessage);
            return "Re-Activation Link send on your mail";
        }
        else
            return "Email does not exist in db";
    }

}
