package com.extrawest.ocpi_emsp_prototype.model;

import com.extrawest.ocpi_emsp_prototype.validation.ValidationRules;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.extrawest.ocpi_emsp_prototype.validation.ValidatorBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("response_url")
    protected String responseUrl;

    @JsonIgnore
    public transient String type;

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
