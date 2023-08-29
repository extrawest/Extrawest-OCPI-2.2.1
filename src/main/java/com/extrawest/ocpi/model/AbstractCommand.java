package com.extrawest.ocpi.model;

import com.extrawest.ocpi.validation.ValidationRules;
import com.extrawest.ocpi.validation.Validator;
import com.extrawest.ocpi.validation.ValidatorBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public abstract class AbstractCommand {

    @JsonIgnore
    protected final transient Validator responseUrlValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();

    /**
     * URL that the CommandResult POST should be send to. This URL might
     * contain an unique ID to be able to distinguish between ReserveNow
     * requests.
     */
    @NotBlank
    @Size(min = 1, max = 255)
    @JsonProperty("response_url")
    protected String responseUrl;

    @JsonIgnore
    public String type;

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
