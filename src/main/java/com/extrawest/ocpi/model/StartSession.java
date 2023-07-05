package com.extrawest.ocpi.model;

import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
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
public class StartSession extends AbstractCommand implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonIgnore
    protected final transient Validator locationIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final transient Validator connectorIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final transient Validator evseUidValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final transient Validator authorizationReferenceValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * Token object the Charge Point has to use to start a new session. The Token provided in this request
     * is authorized by the eMSP.
     */
    @JsonProperty("token")
    private Token token;

    /**
     * Location.id of the Location (belonging to the CPO this request is send to) on which a session is to be started.
     */
    @JsonProperty("location_id")
    private String locationId;

    /**
     * Optional EVSE.uid of the EVSE of this Location on which a session is to be started.
     * Required when connector_id is set.
     */
    @JsonProperty("evse_uid")
    private String evseUid;

    /**
     * Optional Connector.id of the Connector of the EVSE on which a session is to be started.
     * This field is required when the capability: START_SESSION_CONNECTOR_REQUIRED is set on the EVSE.
     */
    @JsonProperty("connector_id")
    private String connectorId;

    /**
     * Reference to the authorization given by the eMSP, when given, this reference will be provided
     * in the relevant Session and/or CDR.
     */
    @JsonProperty("authorization_reference")
    private String authorizationReference;

    public void setResponseUrl(String responseUrl) {
        responseUrlValidator.validate(responseUrl);
        super.responseUrl = responseUrl;
    }

    public void setToken(Token token) {
        requiredValidator.validate(token);
        this.token = token;
    }

    public void setLocationId(String locationId) {
        locationIdValidator.validate(locationId);
        this.locationId = locationId;
    }

    public void setEvseUid(String evseUid) {
        evseUidValidator.validate(evseUid);
        this.evseUid = evseUid;
    }

    public void setConnectorId(String connectorId) {
        connectorIdValidator.validate(connectorId);
        this.connectorId = connectorId;
    }

    public void setAuthorizationReference(String authorizationReference) {
        authorizationReferenceValidator.validate(authorizationReference);
        this.authorizationReference = authorizationReference;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(responseUrl)
                && requiredValidator.safeValidate(token)
                && token.validate()
                && locationIdValidator.safeValidate(locationId);
    }
}
