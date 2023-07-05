package com.extrawest.ocpi.model;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.ValidationRules;
import com.extrawest.ocpi.validation.Validator;
import com.extrawest.ocpi.validation.ValidatorBuilder;
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
    private final Validator sessionIdValidator =
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
