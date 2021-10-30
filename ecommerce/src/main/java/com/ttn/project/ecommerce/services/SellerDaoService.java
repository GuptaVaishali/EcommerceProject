package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.Customer;
import com.ttn.project.ecommerce.entities.Role;
import com.ttn.project.ecommerce.entities.Seller;
import com.ttn.project.ecommerce.repos.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerDaoService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Seller createSeller(Seller seller){
        passwordEncoder.encode(seller.getPassword());
        Role role = new Role();
        role.setAuthority("Seller");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        seller.setRoles(roles);
        return sellerRepository.save(seller);
    }

    public List<Seller> getAllSellers(){
        return (List<Seller>) sellerRepository.findAll();
    }


}
