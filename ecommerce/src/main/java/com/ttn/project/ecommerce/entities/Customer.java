package com.ttn.project.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.ttn.project.ecommerce.validations.Phone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@JsonFilter("customerFilter")
public class Customer extends User{

    @Column(name = "CONTACT")
    @NotNull
    @NotEmpty
    @Phone
    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
