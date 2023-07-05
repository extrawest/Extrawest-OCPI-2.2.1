package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.CommandResultType;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CommandResult implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Result of the command request as sent by the Charge Point to the CPO.
     */
    @JsonProperty("result")
    private CommandResultType result;

    /**
     * Human-readable description of the reason (if one can be provided), multiple languages can be provided.
     */
    @JsonProperty("message")
    private DisplayText message;

    public void setResult(CommandResultType result) {
        requiredValidator.validate(result);
        this.result = result;
    }

    public void setMessage(DisplayText message) {
        this.message = message;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(result);
    }
}
