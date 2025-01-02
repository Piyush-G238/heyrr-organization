package com.heyrr.organization.validators;

import com.heyrr.organization.annotations.NoBackDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NoBackDateValidator implements ConstraintValidator<NoBackDate, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value != null) {
            if (value instanceof LocalDate) {
                return !((LocalDate) value).isBefore(LocalDate.now());
            } else if (value instanceof LocalDateTime) {
                return !((LocalDateTime) value).isBefore(LocalDateTime.now());
            }
        }
        return true;
    }
}
