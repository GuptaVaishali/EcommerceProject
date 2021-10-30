package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.Role;
import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {

    @Autowired
    UserRepository userRepository;
//
//    //create user
    public User createUser(User user){
            Role role1 = new Role();
            role1.setAuthority("customer");
     //       roles.add(role1);
            return userRepository.save(user);
     }

//
//    /* Perform Read Operation on Entity using Spring Data JPA */
//    public List<User> readAllUsers(){
//        return (List<User>) userRepository.findAll();
//    }
}
