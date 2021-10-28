package com.ttn.project.ecommerce.controllers;

import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

//    @Autowired
//    UserDaoService userDaoService;
//
//    @GetMapping("/users")
//    public List<User> retrieveAllEmployees() {
//        return userDaoService.readAllUsers();
//    }
//
////    creating and returning same user
//    @PostMapping("/users")
//    public User createUser(@RequestBody User user){
//        System.out.println(user.getFirstName());
//        User savedUser = userDaoService.createUser(user);
//        return savedUser;
//    }

    // creating employee and send response status created 201.
//    @PostMapping("/users")
//    public ResponseEntity<Object> createUser(@RequestBody User user){
//        User savedUser = userDaoService.createUser(user);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("{id}")
//                .buildAndExpand(savedUser.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }
}
