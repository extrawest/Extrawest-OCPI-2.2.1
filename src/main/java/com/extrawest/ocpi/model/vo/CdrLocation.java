package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.ConnectorFormat;
import com.extrawest.ocpi.model.enums.ConnectorType;
import com.extrawest.ocpi.model.enums.PowerType;
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
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CdrLocation implements Validatable {

    @JsonIgnore
    private final Validator<Object> requiredValidator = new RequiredValidator();

    @JsonIgnore
    private final Validator idValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();
    @JsonIgnore
    private final Validator nameValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string255())
                    .build();
    @JsonIgnore
    private final Validator addressValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string45())
                    .build();
    @JsonIgnore
    private final Validator cityValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string45())
                    .build();
    @JsonIgnore
    private final Validator postalCodeValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string10())
                    .build();
    @JsonIgnore
    private final Validator stateValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string20())
                    .build();
    @JsonIgnore
    private final Validator countryValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final Validator evseUidValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator evseIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string48())
                    .build();

    @JsonIgnore
    private final Validator connectorIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * Uniquely identifies the location within the CPO’s platform (and suboperator platforms). This field can
     * never be changed, modified or renamed.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Display name of the location.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Street/block name and house number if available.
     */
    @JsonProperty("address")
    private String address;

    /**
     * City or town.
     */
    @JsonProperty("city")
    private String city;

    /**
     * Postal code of the location, may only be omitted when the location has no postal code: in some countries
     * charging locations at highways don’t have postal codes.
     */
    @JsonProperty("postal_code")
    private String postalCode;

    /**
     * State only to be used when relevant.
     */
    @JsonProperty("state")
    private String state;

    /**
     * ISO 3166-1 alpha-3 code for the country of this location.
     */
    @JsonProperty("country")
    private String country;

    /**
     * Coordinates of the location.
     */
    @JsonProperty("coordinates")
    private GeoLocation coordinates;

    /**
     * Uniquely identifies the EVSE within the CPO’s platform (and suboperator platforms).
     * For example a database unique ID or the actual EVSE ID. This field can never be changed, modified or renamed.
     * This is the technical identification of the EVSE, not to be used as human readable identification, use the field:
     * evse_id for that. Allowed to be set to: #NA when this CDR is created for a reservation that never resulted
     * in a charging session.
     */
    @JsonProperty("evse_uid")
    private String evseUid;

    /**
     * Compliant with the following specification for EVSE ID from "eMI3 standard version V1.0"
     * (<a href="http://emi3group.com/documents-links/">...</a>) "Part 2: business objects.".
     * Allowed to be set to: #NA when this CDR is created for a reservation that never resulted in a charging session.
     */
    @JsonProperty("evse_id")
    private String evseId;

    /**
     * Identifier of the connector within the EVSE. Allowed to be set to: #NA when this CDR is created
     * for a reservation that never resulted in a charging session.
     */
    @JsonProperty("connector_id")
    private String connectorId;

    /**
     * The standard of the installed connector. When this CDR is created for a reservation that never resulted
     * in a charging session, this field can be set to any value and should be ignored by the Receiver.
     */
    @JsonProperty("connector_standard")
    private ConnectorType connectorStandard;

    /**
     * The format (socket/cable) of the installed connector. When this CDR is created for a reservation that
     * never resulted in a charging session, this field can be set to any value and should be ignored by the Receiver.
     */
    @JsonProperty("connector_format")
    private ConnectorFormat connectorFormat;

    /**
     * When this CDR is created for a reservation that never resulted in a charging session, this field can be set
     * to any value and should be ignored by the Receiver.
     */
    @JsonProperty("connector_power_type")
    private PowerType connectorPowerType;

    public void setId(String id) {
        idValidator.validate(id);
        this.id = id;
    }

    public void setName(String name) {
        nameValidator.validate(name);
        this.name = name;
    }

    public void setAddress(String address) {
        addressValidator.validate(address);
        this.address = address;
    }

    public void setCity(String city) {
        cityValidator.validate(city);
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        postalCodeValidator.validate(postalCode);
        this.postalCode = postalCode;
    }

    public void setState(String state) {
        stateValidator.validate(state);
        this.state = state;
    }

    public void setCountry(String country) {
        countryValidator.validate(country);
        this.country = country;
    }

    public void setCoordinates(GeoLocation coordinates) {
        requiredValidator.validate(coordinates);
        this.coordinates = coordinates;
    }

    public void setEvseUid(String evseUid) {
        evseUidValidator.validate(evseUid);
        this.evseUid = evseUid;
    }

    public void setEvseId(String evseId) {
        evseIdValidator.validate(evseId);
        this.evseId = evseId;
    }

    public void setConnectorId(String connectorId) {
        connectorIdValidator.validate(connectorId);
        this.connectorId = connectorId;
    }

    public void setConnectorStandard(ConnectorType connectorStandard) {
        requiredValidator.validate(connectorStandard);
        this.connectorStandard = connectorStandard;
    }

    public void setConnectorFormat(ConnectorFormat connectorFormat) {
        requiredValidator.validate(connectorFormat);
        this.connectorFormat = connectorFormat;
    }

    public void setConnectorPowerType(PowerType connectorPowerType) {
        requiredValidator.validate(connectorPowerType);
        this.connectorPowerType = connectorPowerType;
    }

    @Override
    public boolean validate() {
        return idValidator.safeValidate(id)
                && addressValidator.safeValidate(address)
                && cityValidator.safeValidate(city)
                && countryValidator.safeValidate(country)
                && requiredValidator.safeValidate(coordinates)
                && coordinates.validate()
                && evseUidValidator.safeValidate(evseUid)
                && evseIdValidator.safeValidate(evseId)
                && connectorIdValidator.safeValidate(connectorId)
                && requiredValidator.safeValidate(connectorStandard)
                && requiredValidator.safeValidate(connectorFormat)
                && requiredValidator.safeValidate(connectorPowerType);
    }
}
