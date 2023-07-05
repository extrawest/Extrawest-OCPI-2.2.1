package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.AuthMethod;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.model.vo.*;
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

/**
 * The CDR object describes the charging session and its costs, how these costs are composed, etc.
 * The CDR object is different from the Session object. The Session object is dynamic as it reflects the current
 * state of the charging session.
 * The information is meant to be viewed by the driver while the charging session is ongoing.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CDR implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonIgnore
    private final Validator chargingPeriodsValidator = new ListOfAtLeastOneObjects();

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
                    .addRule(ValidationRules.string39())
                    .build();

    @JsonIgnore
    private final Validator sessionIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator authorizationReferenceValidator =
            new ValidatorBuilder()
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
    private final Validator remarkValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string255())
                    .build();

    @JsonIgnore
    private final Validator invoiceReferenceIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string39())
                    .build();

    @JsonIgnore
    private final Validator creditReferenceIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string39())
                    .build();

    /**
     * ISO-3166 alpha-2 country code of the CPO that 'owns' this CDR.
     */
    @JsonProperty("country_code")
    private String countryCode;
    /**
     * ID of the CPO that 'owns' this CDR (following the ISO-15118 standard).
     */
    @JsonProperty("party_id")
    private String partyId;
    /**
     * Uniquely identifies the CDR, the ID SHALL be unique per country_code/party_id combination.
     * This field is longer than the usual 36 characters to allow for credit CDRs to have something appended to
     * the original ID. Normal (non-credit) CDRs SHALL only have an ID with a maximum length of 36.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Start timestamp of the charging session, or in-case of a reservation (before the start of a session) the start
     * of the reservation.
     */
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    /**
     * The timestamp when the session was completed/finished, charging might have finished before the session ends,
     * for example: EV is full, but parking cost also has to be paid
     */
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;

    /**
     * Unique ID of the Session for which this CDR is sent. Is only allowed to be omitted when
     * the CPO has not implemented the Sessions module or this CDR is the result of a reservation that never became
     * a charging session, thus no OCPI Session.
     */
    @JsonProperty("session_id")
    private String sessionId;

    /**
     * Token used to start this charging session, including all the relevant information to identify the unique token.
     */
    @JsonProperty("cdr_token")
    private CdrToken cdrToken;

    /**
     * Method used for authentication. Multiple <mod_cdrs_authmethod_enum,AuthMethods>> are possible during
     * a charging sessions, for example when the session was started with a reservation: ReserveNow: COMMAND.
     * When the driver arrives and starts charging using a Token that is whitelisted: WHITELIST.
     * The last method SHALL be used in the CDR.
     */
    @JsonProperty("auth_method")
    private AuthMethod authMethod;

    /**
     * Reference to the authorization given by the eMSP. When the eMSP provided an authorization_reference
     * in either: real-time authorization, StartSession or ReserveNow, this field SHALL contain the same value.
     * When different authorization_reference values have been given by the eMSP that are relevant to this Session,
     * the last given value SHALL be used here.
     */
    @JsonProperty("authorization_reference")
    private String authorizationReference;

    /**
     * Location where the charging session took place, including only the relevant EVSE and Connector.
     */
    @JsonProperty("cdr_location")
    private CdrLocation cdrLocation;

    /**
     * Identification of the Meter inside the Charge Point.
     */
    @JsonProperty("meter_id")
    private String meterId;

    /**
     * Currency of the CDR in ISO 4217 Code.
     */
    @JsonProperty("currency")
    private String currency;

    /**
     * List of relevant Tariff Elements, see: Tariff. When relevant, a Free of Charge tariff should also be in this list,
     * and point to a defined Free of Charge Tariff.
     */
    @JsonProperty("tariffs")
    private List<Tariff> tariffs;

    /**
     * List of Charging Periods that make up this charging session. A session consists of 1 or more periods,
     * where each period has a different relevant Tariff.
     */
    @JsonProperty("charging_periods")
    private List<ChargingPeriod> chargingPeriods;

    /**
     * Signed data that belongs to this charging Session.
     */
    @JsonProperty("signed_data")
    private SignedData signedData;

    /**
     * Total sum of all the costs of this transaction in the specified currency.
     */
    @JsonProperty("total_cost")
    private Price totalCost;

    /**
     * Total sum of all the fixed costs in the specified currency, except fixed price components of parking
     * and reservation. The cost not depending on amount of time/energy used etc. Can contain costs like a start tariff.
     */
    @JsonProperty("total_fixed_cost")
    private Price totalFixedCost;

    /**
     * Total energy charged, in kWh.
     */
    @JsonProperty("total_energy")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float totalEnergy;

    /**
     * Total sum of all the cost of all the energy used, in the specified currency.
     */
    @JsonProperty("total_energy_cost")
    private Price totalEnergyCost;

    /**
     * Total duration of the charging session (including the duration of charging and not charging), in hours.
     */
    @JsonProperty("total_time")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float totalTime;

    /**
     * Total sum of all the cost related to duration of charging during this transaction, in the specified currency.
     */
    @JsonProperty("total_time_cost")
    private Price totalTimeCost;

    /**
     * Total duration of the charging session where the EV was not charging
     * (no energy was transferred between EVSE and EV), in hours.
     */
    @JsonProperty("total_parking_time")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float totalParkingTime;

    /**
     * Total sum of all the cost related to parking of this transaction, including fixed price components,
     * in the specified currency.
     */
    @JsonProperty("total_parking_cost")
    private Price totalParkingCost;

    /**
     * Total sum of all the cost related to a reservation of a Charge Point, including fixed price components,
     * in the specified currency.
     */
    @JsonProperty("total_reservation_cost")
    private Price totalReservationCost;

    /**
     * Optional remark, can be used to provide additional human readable information to the CDR,
     * for example: reason why a transaction was stopped.
     */
    @JsonProperty("remark")
    private String remark;

    /**
     * This field can be used to reference an invoice, that will later be send for this CDR.
     * Making it easier to link a CDR to a given invoice. Maybe even group CDRs that will be on the same invoice.
     */
    @JsonProperty("invoice_reference_id")
    private String invoiceReferenceId;

    /**
     * When set to true, this is a Credit CDR, and the field credit_reference_id needs to be set as well.
     */
    @JsonProperty("credit")
    private Boolean credit;

    /**
     * Is required to be set for a Credit CDR. This SHALL contain the id of the CDR for which this is a Credit CDR.
     */
    @JsonProperty("credit_reference_id")
    private String creditReferenceId;

    /**
     * When set to true, this CDR is for a charging session using the home charger of the EV Driver for which the
     * energy cost needs to be financial compensated to the EV Driver.
     */
    @JsonProperty("home_charging_compensation")
    private Boolean homeChargingCompensation;

    /**
     * Timestamp when this CDR was last updated (or created).
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
        requiredValidator.validate(endDateTime);
        this.endDateTime = endDateTime;
    }

    public void setSessionId(String sessionId) {
        sessionIdValidator.validate(sessionId);
        this.sessionId = sessionId;
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

    public void setCdrLocation(CdrLocation cdrLocation) {
        requiredValidator.validate(cdrLocation);
        this.cdrLocation = cdrLocation;
    }

    public void setMeterId(String meterId) {
        meterIdValidator.validate(meterId);
        this.meterId = meterId;
    }

    public void setCurrency(String currency) {
        currencyValidator.validate(currency);
        this.currency = currency;
    }

    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public void setChargingPeriods(List<ChargingPeriod> chargingPeriods) {
        chargingPeriodsValidator.validate(chargingPeriods);
        this.chargingPeriods = chargingPeriods;
    }

    public void setSignedData(SignedData signedData) {
        this.signedData = signedData;
    }

    public void setTotalCost(Price totalCost) {
        requiredValidator.validate(totalCost);
        this.totalCost = totalCost;
    }

    public void setTotalFixedCost(Price totalFixedCost) {
        this.totalFixedCost = totalFixedCost;
    }

    public void setTotalEnergy(Float totalEnergy) {
        requiredValidator.validate(totalEnergy);
        this.totalEnergy = totalEnergy;
    }

    public void setTotalEnergyCost(Price totalEnergyCost) {
        this.totalEnergyCost = totalEnergyCost;
    }

    public void setTotalTime(Float totalTime) {
        requiredValidator.validate(totalTime);
        this.totalTime = totalTime;
    }

    public void setTotalTimeCost(Price totalTimeCost) {
        this.totalTimeCost = totalTimeCost;
    }

    public void setTotalParkingTime(Float totalParkingTime) {
        this.totalParkingTime = totalParkingTime;
    }

    public void setTotalParkingCost(Price totalParkingCost) {
        this.totalParkingCost = totalParkingCost;
    }

    public void setTotalReservationCost(Price totalReservationCost) {
        this.totalReservationCost = totalReservationCost;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setInvoiceReferenceId(String invoiceReferenceId) {
        this.invoiceReferenceId = invoiceReferenceId;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public void setCreditReferenceId(String creditReferenceId) {
        this.creditReferenceId = creditReferenceId;
    }

    public void setHomeChargingCompensation(Boolean homeChargingCompensation) {
        this.homeChargingCompensation = homeChargingCompensation;
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
                && requiredValidator.safeValidate(endDateTime)
                && requiredValidator.safeValidate(cdrToken)
                && cdrToken.validate()
                && requiredValidator.safeValidate(authMethod)
                && requiredValidator.safeValidate(cdrLocation)
                && cdrLocation.validate()
                && currencyValidator.safeValidate(currency)
                && chargingPeriodsValidator.safeValidate(chargingPeriods)
                && chargingPeriods.stream().filter(ChargingPeriod::validate).count() == chargingPeriods.size()
                && requiredValidator.safeValidate(totalCost)
                && requiredValidator.safeValidate(totalEnergy)
                && requiredValidator.safeValidate(totalTime)
                && requiredValidator.safeValidate(lastUpdated);
    }
}
