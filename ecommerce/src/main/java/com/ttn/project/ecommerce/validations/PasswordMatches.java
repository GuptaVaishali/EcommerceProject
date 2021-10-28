package com.ttn.project.ecommerce.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface  PasswordMatches {

    String message() default "{Password and Confirm Password do not match}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}