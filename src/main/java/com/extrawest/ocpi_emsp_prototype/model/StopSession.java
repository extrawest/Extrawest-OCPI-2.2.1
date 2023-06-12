package com.extrawest.ocpi_emsp_prototype.model;

import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.ValidationRules;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.extrawest.ocpi_emsp_prototype.validation.ValidatorBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class StopSession extends AbstractCommand implements Validatable {

    @JsonIgnore
    private final transient Validator sessionIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * Session.id of the Session that is requested to be stopped.
     */
    @JsonProperty("session_id ")
    private String sessionId;

    public void setResponseUrl(String responseUrl) {
        responseUrlValidator.validate(responseUrl);
        super.responseUrl = responseUrl;
    }

    public void setSessionId(String sessionId) {
        sessionIdValidator.validate(sessionId);
        this.sessionId = sessionId;
    }

    @Override
    public boolean validate() {
        return responseUrlValidator.safeValidate(responseUrl)
                && sessionIdValidator.safeValidate(sessionId);
    }
}
