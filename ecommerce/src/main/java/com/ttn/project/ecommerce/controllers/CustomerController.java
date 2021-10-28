package com.ttn.project.ecommerce.controllers;

import com.ttn.project.ecommerce.entities.Customer;
import com.ttn.project.ecommerce.services.CustomerDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerDaoService customerDaoService;

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
    @PostMapping("/customerusers")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Customer customer){
        Customer savedCustomer = customerDaoService.createCustomerUser(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(savedCustomer.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
