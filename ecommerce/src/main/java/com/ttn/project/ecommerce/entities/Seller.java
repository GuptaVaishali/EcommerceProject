package com.ttn.project.ecommerce.entities;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Seller extends User{

    @Column(name = "GST")
    private float gst;

    @Column(name = "COMPANY_CONTACT")
    private Long companyContact;

    @Column(name = "COMPANY_NAME")
    private String companyName;
}
