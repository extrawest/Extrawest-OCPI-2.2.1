package com.extrawest.ocpi_emsp_prototype.validation;

import com.extrawest.ocpi_emsp_prototype.exception.PropertyConstraintException;

import java.util.List;

public class ListOfAtLeastOneObjects extends Validator<List> {

    private final String ERROR_MESSAGE = "List should have at least one object.";

    @Override
    public void validate(List value) throws PropertyConstraintException {
        if (value.isEmpty()) {
            throw new PropertyConstraintException(value, ERROR_MESSAGE);
        }
    }
}
