package com.extrawest.ocpi_emsp_prototype.model;

import com.extrawest.ocpi_emsp_prototype.validation.RequiredValidator;
import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public abstract class ResponseFormat implements Validatable {

    @JsonIgnore
    private final transient Validator requiredValidator = new RequiredValidator();

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
