package com.extrawest.ocpi_emsp_prototype.validation;

public class OptionalDecorator extends Validator<String> {
    private final Validator validator;

    public OptionalDecorator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(String value) {
        if (value == null) return;

        this.validator.validate(value);
    }
}
