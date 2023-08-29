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
public class UnlockConnector extends AbstractCommand implements Validatable {

    @JsonIgnore
    protected final Validator locationIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final Validator evseUidValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final Validator connectorIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * Location.id of the Location (belonging to the CPO this request is send to) of which it is requested
     * to unlock the connector.
     */
    @JsonProperty("location_id")
    private String locationId;

    /**
     * EVSE.uid of the EVSE of this Location of which it is requested to unlock the connector.
     */
    @JsonProperty("evse_uid")
    private String evseUid;

    /**
     * Connector.id of the Connector of this Location of which it is requested to unlock.
     */
    @JsonProperty("connector_id")
    private String connectorId;

    public void setResponseUrl(String responseUrl) {
        responseUrlValidator.validate(responseUrl);
        super.responseUrl = responseUrl;
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

    @Override
    public boolean validate() {
        return responseUrlValidator.safeValidate(responseUrl)
                && locationIdValidator.safeValidate(locationId)
                && evseUidValidator.safeValidate(evseUid)
                && connectorIdValidator.safeValidate(connectorId);
    }
}
