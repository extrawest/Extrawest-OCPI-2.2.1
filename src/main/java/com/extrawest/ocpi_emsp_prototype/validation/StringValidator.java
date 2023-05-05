package com.extrawest.ocpi_emsp_prototype.validation;

import com.extrawest.ocpi_emsp_prototype.exception.PropertyConstraintException;

public class StringValidator extends Validator<String> {
    private final IValidationRule[] rules;

    public StringValidator(IValidationRule[] rules) {
        this.rules = rules;
    }

    public void validate(String value) throws PropertyConstraintException {
        for (IValidationRule rule : rules) {
            rule.validate(value);
        }
    }
}
