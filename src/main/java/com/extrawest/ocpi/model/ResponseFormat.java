package com.extrawest.ocpi.model;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public abstract class ResponseFormat implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonProperty("status_code")
    protected Integer statusCode;
    protected LocalDateTime timestamp;
    @JsonProperty("status_message")
    protected String statusMessage;

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(statusCode)
                && requiredValidator.safeValidate(timestamp);
    }
}
