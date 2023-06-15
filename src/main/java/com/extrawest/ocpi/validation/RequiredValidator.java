package com.extrawest.ocpi.validation;

import com.extrawest.ocpi.exception.PropertyConstraintException;

public class RequiredValidator extends Validator<Object> {
    private final String ERROR_MESSAGE = "Field is required and must not be Null.";

    @Override
    public void validate(Object value) throws PropertyConstraintException {
        if (value == null) {
            throw new PropertyConstraintException(ERROR_MESSAGE, null);
        }
    }
}
