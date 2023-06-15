package com.extrawest.ocpi.validation;

import com.extrawest.ocpi.exception.PropertyConstraintException;

public class RequiredDecorator extends Validator<Object> {
    private final Validator<Object> requiredValidator = new RequiredValidator();
    private final Validator<Object> decoratee;

    public RequiredDecorator(Validator<Object> validator) {
        this.decoratee = validator;
    }

    @Override
    public void validate(Object value) throws PropertyConstraintException {
        requiredValidator.validate(value);
        decoratee.validate(value);
    }
}
