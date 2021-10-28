package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.Customer;
import com.ttn.project.ecommerce.entities.Seller;
import com.ttn.project.ecommerce.repos.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerDaoService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller createSeller(Seller seller){
        return sellerRepository.save(seller);
    }

    public List<Seller> getAllSellers(){
        return (List<Seller>) sellerRepository.findAll();
    }
}
