package com.ttn.project.ecommerce.entities;

import com.ttn.project.ecommerce.validations.Gst;
import com.ttn.project.ecommerce.validations.Phone;
import com.ttn.project.ecommerce.validations.UniqueCompany;
import com.ttn.project.ecommerce.validations.UniqueGst;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Seller extends User{

    @Column(name = "GST")
    @UniqueGst
    @Gst
    @NotNull
    @NotEmpty
    private String gst;

    @Column(name = "COMPANY_CONTACT")
    @Phone
    @NotNull
    @NotEmpty
    private String companyContact;

    @Column(name = "COMPANY_NAME")
    @NotNull
    @NotEmpty
    @UniqueCompany
    private String companyName;


    //getters and setters
    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
