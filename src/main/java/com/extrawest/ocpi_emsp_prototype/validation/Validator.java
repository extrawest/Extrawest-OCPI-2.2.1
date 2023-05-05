package com.extrawest.ocpi_emsp_prototype.validation;

import com.extrawest.ocpi_emsp_prototype.exception.PropertyConstraintException;

public abstract class Validator<T> {

    public boolean safeValidate(T value) {
        boolean returnValue = true;
        try {
            this.validate(value);
        } catch (Exception ex) {
            returnValue = false;
        }
        return returnValue;
    }

    public abstract void validate(T value) throws PropertyConstraintException;
}
