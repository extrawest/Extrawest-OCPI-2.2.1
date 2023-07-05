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

/**
 * With CancelReservation the Sender can request the Cancel of an existing Reservation.
 * The CancelReservation needs to contain the reservation_id that was given by the Sender to the ReserveNow.
 * As there might be cost involved for a Reservation, canceling a reservation might still result
 * in a CDR being send for the reservation.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CancelReservation implements Validatable {

    @JsonIgnore
    private final Validator responseUrlValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();

    @JsonIgnore
    private final Validator reservationIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * URL that the CommandResult POST should be send to. This URL might contain an unique ID
     * to be able to distinguish between CancelReservation requests.
     */
    @JsonProperty("response_url")
    private String responseUrl;

    /**
     * Reservation id, unique for this reservation. If the Charge Point already has a reservation that matches
     * this reservationId the Charge Point will replace the reservation.
     */
    @JsonProperty("reservation_id")
    private String reservationId;

    public void setResponseUrl(String responseUrl) {
        responseUrlValidator.validate(responseUrl);
        this.responseUrl = responseUrl;
    }

    public void setReservationId(String reservationId) {
        reservationIdValidator.validate(reservationId);
        this.reservationId = reservationId;
    }

    @Override
    public boolean validate() {
        return reservationIdValidator.safeValidate(reservationId)
                && reservationIdValidator.safeValidate(responseUrl);
    }
}
