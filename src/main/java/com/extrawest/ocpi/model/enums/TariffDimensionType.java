package com.extrawest.ocpi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi.util.EnumUtil.findByField;

public enum TariffDimensionType {
    /**
     * Defined in kWh, step_size multiplier: 1 Wh
     */
    ENERGY("ENERGY"),
    /**
     * Flat fee without unit for step_size
     */
    FLAT("FLAT"),
    /**
     * Time not charging: defined in hours, step_size multiplier: 1 second
     */
    PARKING_TIME("PARKING_TIME"),
    /**
     * Time charging: defined in hours, step_size multiplier: 1 second
     * Can also be used in combination with a RESERVATION restriction to describe the price of the reservation time.
     */
    TIME("TIME");
    private final String value;

    TariffDimensionType(String value) {
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
    public static TariffDimensionType fromValue(String value) {
        return findByField(
                TariffDimensionType.class,
                TariffDimensionType::value,
                value
        );
    }
}
