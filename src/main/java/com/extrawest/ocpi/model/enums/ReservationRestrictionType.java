package com.extrawest.ocpi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi.util.EnumUtil.findByField;

public enum ReservationRestrictionType {
    /**
     * Used in TariffElements to describe costs for a reservation.
     */
    RESERVATION("RESERVATION"),
    /**
     * Used in TariffElements to describe costs for a reservation that expires (i.e. driver does not start a
     * charging session before expiry_date of the reservation)
     */
    RESERVATION_EXPIRES("RESERVATION_EXPIRES");
    private final String value;

    ReservationRestrictionType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static ReservationRestrictionType fromValue(String value) {
        return findByField(
                ReservationRestrictionType.class,
                ReservationRestrictionType::value,
                value
        );
    }
}
