package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.Role;
import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.repos.RoleRepository;
import com.ttn.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    public Role createRole(Role role){
//        role.setAuthority("Admin");
//        List<User> users = new ArrayList<>();
//        User user1 = userRepository.findById(role.getId()).get();
//        users.add(user1);
//        role.setUsers(users);
        return roleRepository.save(role);
    }


}
