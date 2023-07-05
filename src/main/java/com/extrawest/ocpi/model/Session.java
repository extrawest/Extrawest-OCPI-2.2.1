package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.AuthMethod;
import com.extrawest.ocpi.model.enums.SessionStatus;
import com.extrawest.ocpi.model.vo.CdrToken;
import com.extrawest.ocpi.model.vo.ChargingPeriod;
import com.extrawest.ocpi.model.vo.Price;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Session implements Validatable {

    @JsonIgnore
    private final Validator countryCodeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string2())
                    .build();

    @JsonIgnore
    private final Validator partyIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final Validator idValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator authorizationReferenceValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final transient Validator locationIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final transient Validator evseUidValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final transient Validator connectorIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator meterIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string255())
                    .build();

    @JsonIgnore
    private final Validator currencyValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * ISO-3166 alpha-2 country code of the CPO that 'owns' this Session.
     */
    @JsonProperty("country_code")
    private String countryCode;
    /**
     * ID of the CPO that 'owns' this Session (following the ISO-15118 standard).
     */
    @JsonProperty("party_id")
    private String partyId;
    /**
     * ID of the CPO that 'owns' this Session (following the ISO-15118 standard).
     */
    @JsonProperty("id")
    private String id;

    /**
     * The timestamp when the session became ACTIVE in the Charge Point. When the session is still PENDING,
     * this field SHALL be set to the time the Session was created at the Charge Point. When a Session goes from PENDING
     * to ACTIVE, this field SHALL be updated to the moment the Session went to ACTIVE in the Charge Point.
     */
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    /**
     * The timestamp when the session was completed/finished, charging might have finished before the session ends,
     * for example: EV is full, but parking cost also has to be paid.
     */
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;

    /**
     * How many kWh were charged.
     */
    @JsonProperty("kwh")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float kwh;

    /**
     * Token used to start this charging session, including all the relevant information to identify the unique token.
     */
    @JsonProperty("cdr_token")
    private CdrToken cdrToken;

    /**
     * Method used for authentication. This might change during a session, for example when the session was started
     * with a reservation: ReserveNow: COMMAND. When the driver arrives and starts charging using a Token that
     * is whitelisted: WHITELIST.
     */
    @JsonProperty("auth_method")
    private AuthMethod authMethod;

    /**
     * Reference to the authorization given by the eMSP. When the eMSP provided an authorization_reference
     * in either: real-time authorization, StartSession or ReserveNow this field SHALL contain the same value.
     * When different authorization_reference values have been given by the eMSP that are relevant to this Session,
     * the last given value SHALL be used here.
     */
    @JsonProperty("authorization_reference")
    private String authorizationReference;

    /**
     * Location.id of the Location object of this CPO, on which the charging session is/was happening.
     */
    @JsonProperty("location_id")
    private String locationId;

    /**
     * EVSE.uid of the EVSE of this Location on which the charging session is/was happening.
     * Allowed to be set to: #NA when this session is created for a reservation, but no EVSE yet assigned to the driver.
     */
    @JsonProperty("evse_uid")
    private String evseUid;

    /**
     * Connector.id of the Connector of this Location where the charging session is/was happening.
     * Allowed to be set to: #NA when this session is created for a reservation, but no connector yet assigned
     * to the driver.
     */
    @JsonProperty("connector_id")
    private String connectorId;

    /**
     * Optional identification of the kWh meter.
     */
    @JsonProperty("meter_id")
    private String meterId;

    /**
     * ISO 4217 code of the currency used for this session.
     */
    @JsonProperty("currency")
    private String currency;

    /**
     * An optional list of Charging Periods that can be used to calculate and verify the total cost.
     */
    @JsonProperty("charging_periods")
    private List<ChargingPeriod> chargingPeriods;

    /**
     * The total cost of the session in the specified currency. This is the price that the eMSP will have to pay
     * to the CPO. A total_cost of 0.00 means free of charge. When omitted, i.e. no price information is given in
     * the Session object, it does not imply the session is/was free of charge.
     */
    @JsonProperty("total_cost")
    private Price totalCost;

    /**
     * The status of the session.
     */
    @JsonProperty("status")
    private SessionStatus status;

    /**
     * Timestamp when this Session was last updated (or created).
     */
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;

    public void setCountryCode(String countryCode) {
        countryCodeValidator.validate(countryCode);
        this.countryCode = countryCode;
    }

    public void setPartyId(String partyId) {
        partyIdValidator.validate(partyId);
        this.partyId = partyId;
    }

    public void setId(String id) {
        idValidator.validate(id);
        this.id = id;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        requiredValidator.validate(startDateTime);
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setKwh(Float kwh) {
        requiredValidator.validate(kwh);
        this.kwh = kwh;
    }

    public void setCdrToken(CdrToken cdrToken) {
        requiredValidator.validate(cdrToken);
        this.cdrToken = cdrToken;
    }

    public void setAuthMethod(AuthMethod authMethod) {
        requiredValidator.validate(authMethod);
        this.authMethod = authMethod;
    }

    public void setAuthorizationReference(String authorizationReference) {
        authorizationReferenceValidator.validate(authorizationReference);
        this.authorizationReference = authorizationReference;
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

    public void setMeterId(String meterId) {
        meterIdValidator.validate(meterId);
        this.meterId = meterId;
    }

    public void setCurrency(String currency) {
        currencyValidator.validate(currency);
        this.currency = currency;
    }

    public void setChargingPeriods(List<ChargingPeriod> chargingPeriods) {
        this.chargingPeriods = chargingPeriods;
    }

    public void setTotalCost(Price totalCost) {
        this.totalCost = totalCost;
    }

    public void setStatus(SessionStatus status) {
        requiredValidator.validate(status);
        this.status = status;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        requiredValidator.validate(lastUpdated);
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean validate() {
        return countryCodeValidator.safeValidate(countryCode)
                && partyIdValidator.safeValidate(partyId)
                && idValidator.safeValidate(id)
                && requiredValidator.safeValidate(startDateTime)
                && requiredValidator.safeValidate(kwh)
                && requiredValidator.safeValidate(cdrToken)
                && requiredValidator.safeValidate(authMethod)
                && locationIdValidator.safeValidate(locationId)
                && evseUidValidator.safeValidate(evseUid)
                && connectorIdValidator.safeValidate(connectorId)
                && currencyValidator.safeValidate(currency)
                && requiredValidator.safeValidate(status)
                && requiredValidator.safeValidate(lastUpdated);
    }
}
