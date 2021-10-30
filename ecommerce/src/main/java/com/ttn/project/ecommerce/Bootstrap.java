package com.ttn.project.ecommerce;

import com.ttn.project.ecommerce.entities.Address;
import com.ttn.project.ecommerce.entities.Role;
import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.repos.RoleRepository;
import com.ttn.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        if(roleRepository.count()<1){
//            Role role1 = new Role();
//            role1.setAuthority("Admin");
//
//            Role role2 = new Role();
//            role2.setAuthority("Seller");
//
//            Role role3 = new Role();
//            role3.setAuthority("Customer");
//
//            roleRepository.save(role1);
//            roleRepository.save(role2);
//            roleRepository.save(role3);
//            System.out.println("Total users saved::"+roleRepository.count());
//
//        }


//        if(userRepository.count()<1){
//            User user = new User();
//            user.setFirstName("Vaishali");
//            user.setLastName("Gupta");
//            user.setEmail("vaishaligupta982@gmail.com");
//            user.setPassword( passwordEncoder.encode("Vaishali@123"));
//
//            List<Address> addresses = new ArrayList<>();
//            Address address = new Address();
//            address.setAddressLine("house no. 123");
//            address.setCity("ballabgarh");
//            address.setCountry("India");
//            address.setLabel("home");
//            address.setState("Haryana");
//            address.setZipCode("121004");
//            addresses.add(address);
//            address.setUser(user);
//            user.setAddresses(addresses);
//
//            Role role = new Role();
//            role.setAuthority("Admin");
//            List<Role> roles = new ArrayList<>();
//            roles.add(role);
//            user.setRoles(roles);
//
//            System.out.println("Total users saved::"+ userRepository.count());

//        }

    }
}
