package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.CommandResponseType;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CommandResponse implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Response from the CPO on the command request.
     */
    @JsonProperty("result")
    private CommandResponseType result;

    /**
     * Timeout for this command in seconds. When the Result is not received within this timeout,
     * the eMSP can assume that the message might never be send.
     */
    @JsonProperty("timeout")
    private Integer timeout;

    /**
     * Human-readable description of the result (if one can be provided), multiple languages can be provided.
     */
    @JsonProperty("message")
    private List<DisplayText> message;

    public void setResult(CommandResponseType result) {
        requiredValidator.validate(result);
        this.result = result;
    }

    public void setTimeout(Integer timeout) {
        requiredValidator.validate(timeout);
        this.timeout = timeout;
    }

    public void setMessage(List<DisplayText> message) {
        this.message = message;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(result)
                && requiredValidator.safeValidate(timeout);
    }
}
