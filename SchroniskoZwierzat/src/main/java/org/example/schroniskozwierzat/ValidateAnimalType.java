package org.example.schroniskozwierzat;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DictionaryValidator.class)

public @interface ValidateAnimalType {
    String message() default "Invalid animal type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
