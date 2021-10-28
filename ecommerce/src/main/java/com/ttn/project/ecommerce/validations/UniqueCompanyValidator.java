package com.ttn.project.ecommerce.validations;

import com.ttn.project.ecommerce.entities.Seller;
import com.ttn.project.ecommerce.repos.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCompanyValidator implements ConstraintValidator<UniqueCompany,String> {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public boolean isValid(String companyName, ConstraintValidatorContext constraintValidatorContext) {
        Seller inDb = sellerRepository.findByCompanyName(companyName);
        if(inDb == null)
            return true;
        return false;
    }
}
