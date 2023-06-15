package com.extrawest.ocpi.validation;

import java.util.ArrayList;

public class ValidatorBuilder {
    private boolean required = false;
    private ArrayList<IValidationRule> rules;

    public ValidatorBuilder() {
        rules = new ArrayList<>();
    }

    public ValidatorBuilder addRule(IValidationRule rule) {
        rules.add(rule);
        return this;
    }

    public ValidatorBuilder setRequired(boolean isRequired) {
        required = isRequired;
        return this;
    }

    public Validator build() {
        Validator validator = new StringValidator(rules.toArray(new IValidationRule[0]));

        if (required) validator = new RequiredDecorator(validator);
        else validator = new OptionalDecorator(validator);

        return validator;
    }
}
