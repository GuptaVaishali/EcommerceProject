package com.ttn.project.ecommerce.controllers;

import com.ttn.project.ecommerce.entities.Seller;
import com.ttn.project.ecommerce.services.SellerDaoService;
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
public class SellerController {

    @Autowired
    SellerDaoService sellerDaoService;

    @GetMapping("/sellerusers")
    public List<Seller> retrieveAllSellers() {
        return sellerDaoService.getAllSellers();
    }

    // creating and returning same user
    @PostMapping("/sellerusers")
    public Seller createSeller(@Valid @RequestBody Seller seller){
        Seller savedSeller = sellerDaoService.createSeller(seller);
        return savedSeller;
    }

//    //  creating seller and send response status created 201.
//    @PostMapping("/sellerusers")
//    public ResponseEntity<Object> createUser(@Valid @RequestBody Seller seller){
//        Seller savedSeller = sellerDaoService.createSeller(seller);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("{id}")
//                .buildAndExpand(savedSeller.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }
}
