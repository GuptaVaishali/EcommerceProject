package com.ttn.project.ecommerce.validations;

import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        User inDb = userRepository.findByEmail(value);
        if(inDb == null)
            return true;
        return false;
    }
}
