package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.Role;
import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
//
//    //create user
//    public User createUser(User user){
//            Role role1 = new Role();
//            role1.setAuthority("admin");
//     //       roles.add(role1);
//            return userRepository.save(user);
//     }

//
//    /* Perform Read Operation on Entity using Spring Data JPA */
//    public List<User> readAllUsers(){
//        return (List<User>) userRepository.findAll();
//    }

    public String checkEmail(String email){
        User user = userRepository.findByEmail(email);
        String str = null;
        if(user == null) {
            str =  "Email does not exist in db";
        }else {
            if (user.isActive() == false)
                str = "User is not active";
        }
        return str;
    }

    public void changeUserPassword(User user,String password){
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        System.out.println("changed Password " + user.getPassword());
    }
}
