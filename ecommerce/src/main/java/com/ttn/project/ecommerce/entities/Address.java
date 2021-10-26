package com.ttn.project.ecommerce.entities;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String city;
    private String state;
    private String country;

    @Column(name = "ADDRESS_LINE")
    private String addressLine;

    @Column(name = "ZIP_CODE")
    private String zipCode;
    private String label;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
