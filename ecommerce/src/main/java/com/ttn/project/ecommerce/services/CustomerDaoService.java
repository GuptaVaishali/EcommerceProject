package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.*;
import com.ttn.project.ecommerce.repos.CustomerRepository;
import com.ttn.project.ecommerce.repos.RoleRepository;
import com.ttn.project.ecommerce.repos.TokenRepository;
import com.ttn.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDaoService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    @Autowired
    TokenRepository tokenRepository;

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //create customer user
    public Customer createCustomerUser(Customer customer){
        List<Role> roles = new ArrayList<>();
//        Role role  = roleRepository.findById(3l).get();
//        System.out.println(">>>>>>>>>>>>>>>>>>>." + role.getAuthority());
//        roles.add(role);

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        System.out.println(">>>>>>>>>>>>>  Password encoded " + passwordEncoder.encode(customer.getPassword()));
        Role role1 = new Role();
        role1.setAuthority("customer");
        roles.add(role1);
        customer.setRoles(roles);

//        List<Address> addresses = new ArrayList<>();
//        Address address = new Address();
//        address.setAddressLine("house no. 123");
//        address.setCity("ballabgarh");
//        address.setCountry("India");
//        address.setLabel("home");
//        address.setState("Haryana");
//        address.setZipCode("121004");
//        addresses.add(address);
//        address.setUser(customer);

//        customer.setAddresses(addresses);
        return customerRepository.save(customer);
    }


    /* Perform Read Operation on Entity using Spring Data JPA */
    public List<Customer> readAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Token generateReToken(String email){
        User user = userRepository.findByEmail(email);
        Token reToken = tokenService.createToken(user);
        tokenRepository.save(reToken);
        return reToken;
    }
}
