package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.Customer;
import com.ttn.project.ecommerce.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDaoService {

    @Autowired
    CustomerRepository customerRepository;

    //create customer user
    public Customer createCustomerUser(Customer customer){
        return customerRepository.save(customer);
    }

    /* Perform Read Operation on Entity using Spring Data JPA */
    public List<Customer> readAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }
}
