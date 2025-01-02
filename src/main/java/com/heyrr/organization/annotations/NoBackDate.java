package com.heyrr.organization.annotations;

import com.heyrr.organization.validators.NoBackDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoBackDateValidator.class)
public @interface NoBackDate {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Back dates are not allowed!";
}
