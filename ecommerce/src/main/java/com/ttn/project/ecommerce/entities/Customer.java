package com.ttn.project.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User{

    @Column(name = "CONTACT")
    private long contact;

}
