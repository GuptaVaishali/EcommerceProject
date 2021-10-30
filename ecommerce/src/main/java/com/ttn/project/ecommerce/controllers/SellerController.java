package com.ttn.project.ecommerce.controllers;

import com.ttn.project.ecommerce.entities.Seller;
import com.ttn.project.ecommerce.services.EmailSenderService;
import com.ttn.project.ecommerce.services.SellerDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class SellerController {

    @Autowired
    SellerDaoService sellerDaoService;

    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping("/sellerusers")
    public List<Seller> retrieveAllSellers() {
        return sellerDaoService.getAllSellers();
    }

//    // creating and returning same user
//    @PostMapping("/register-seller")
//    public Seller createSeller(@Valid @RequestBody Seller seller){
//        Seller savedSeller = sellerDaoService.createSeller(seller);
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(seller.getEmail());
//        mailMessage.setSubject(" Seller Activation Mail");
//        mailMessage.setFrom("vaishgupta97@gmail.com");
//        mailMessage.setText("Account has been created, waiting for approval");
//
//        emailSenderService.sendEmail(mailMessage);
//        return savedSeller;
//    }

    // creating and returning same user
    @PostMapping("/register-seller")
    public ResponseEntity<Object> createSeller(@Valid @RequestBody Seller seller){
        Seller savedSeller = sellerDaoService.createSeller(seller);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(seller.getEmail());
        mailMessage.setSubject("Seller Activation Mail");
        mailMessage.setFrom("vaishgupta97@gmail.com");
        mailMessage.setText("Account has been created, waiting for approval");

        emailSenderService.sendEmail(mailMessage);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(savedSeller.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
