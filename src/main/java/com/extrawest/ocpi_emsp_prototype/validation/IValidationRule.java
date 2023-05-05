package com.extrawest.ocpi_emsp_prototype.validation;

import com.extrawest.ocpi_emsp_prototype.exception.PropertyConstraintException;

public interface IValidationRule {
    void validate(String value) throws PropertyConstraintException;
}
