package com.extrawest.ocpi.validation;

import com.extrawest.ocpi.exception.PropertyConstraintException;

public interface IValidationRule {
    void validate(String value) throws PropertyConstraintException;
}
