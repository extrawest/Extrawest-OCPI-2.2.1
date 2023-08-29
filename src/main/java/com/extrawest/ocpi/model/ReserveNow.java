package com.extrawest.ocpi.model;

import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ReserveNow extends AbstractCommand implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonIgnore
    protected final transient Validator reservationIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
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
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    protected final transient Validator authorizationReferenceValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * Token object for how to reserve this Charge Point (and specific EVSE).
     */
    @JsonProperty("token")
    private Token token;

    /**
     * The Date/Time when this reservation ends, in UTC.
     */
    @JsonProperty("expiry_date")
    private LocalDateTime expiryDate;

    /**
     * Reservation id, unique for this reservation. If the Receiver (typically CPO) Point already has a reservation
     * that matches this reservationId for that Location it will replace the reservation.
     */
    @JsonProperty("reservation_id")
    private String reservationId;

    /**
     * Location.id of the Location (belonging to the CPO this request is send to) for which to reserve an EVSE.
     */
    @JsonProperty("location_id")
    private String locationId;

    /**
     * Optional EVSE.uid of the EVSE of this Location if a specific EVSE has to be reserved.
     */
    @JsonProperty("evse_uid")
    private String evseUid;

    /**
     * Reference to the authorization given by the eMSP, when given, this reference will be provided in the relevant
     * Session and/or CDR.
     */
    @JsonProperty("authorization_reference")
    private String authorizationReference;

    public void setToken(Token token) {
        requiredValidator.validate(token);
        this.token = token;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        requiredValidator.validate(expiryDate);
        this.expiryDate = expiryDate;
    }

    public void setReservationId(String reservationId) {
        reservationIdValidator.validate(reservationId);
        this.reservationId = reservationId;
    }

    public void setLocationId(String locationId) {
        locationIdValidator.validate(locationId);
        this.locationId = locationId;
    }

    public void setEvseUid(String evseUid) {
        evseUidValidator.validate(evseUid);
        this.evseUid = evseUid;
    }

    public void setAuthorizationReference(String authorizationReference) {
        authorizationReferenceValidator.validate(authorizationReference);
        this.authorizationReference = authorizationReference;
    }

    public void setResponseUrl(String responseUrl) {
        responseUrlValidator.validate(responseUrl);
        super.responseUrl = responseUrl;
    }

    @Override
    public boolean validate() {
        return responseUrlValidator.safeValidate(responseUrl)
                && requiredValidator.safeValidate(token)
                && token.validate()
                && requiredValidator.safeValidate(expiryDate)
                && reservationIdValidator.safeValidate(reservationId)
                && locationIdValidator.safeValidate(locationId);
    }
}
