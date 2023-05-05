package com.extrawest.ocpi_emsp_prototype.validation;

import com.extrawest.ocpi_emsp_prototype.exception.PropertyConstraintException;

public class StringMaxLengthValidationRule implements IValidationRule {

    private static final String ERROR_MESSAGE = "Exceeded limit of %s chars";
    private final int maxLength;

    public StringMaxLengthValidationRule(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void validate(String value) throws PropertyConstraintException {
        if (value.length() > maxLength)
            throw new PropertyConstraintException(
                    value.length(), String.format(ERROR_MESSAGE, maxLength));
    }
}
