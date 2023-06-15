package com.extrawest.ocpi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi.util.EnumUtil.findByField;

/**
 * This enumeration contains allowed values for CdrDimensions, which are used to define dimensions of ChargingPeriods
 * in both CDRs and Sessions. Some of these values are not useful for CDRs, and SHALL therefor only be used in Sessions,
 * these are marked: Session Only
 */
public enum CdrDimensionType {
    /**
     * Average charging current during this ChargingPeriod: defined in A (Ampere). When negative, the current
     * is flowing from the EV to the grid.
     * Session Only
     */
    CURRENT("CURRENT"),
    /**
     * Total amount of energy (dis-)charged during this ChargingPeriod: defined in kWh. When negative, more energy
     * was feed into the grid then charged into the EV. Default step_size is 1.
     */
    ENERGY("ENERGY"),
    /**
     * Total amount of energy feed back into the grid: defined in kWh.
     * Session Only
     */
    ENERGY_EXPORT("ENERGY_EXPORT"),
    /**
     * Total amount of energy charged, defined in kWh.
     * Session Only
     */
    ENERGY_IMPORT("ENERGY_IMPORT"),
    /**
     * Sum of the maximum current over all phases, reached during this ChargingPeriod: defined in A (Ampere).
     */
    MAX_CURRENT("MAX_CURRENT"),
    /**
     * Sum of the minimum current over all phases, reached during this ChargingPeriod, when negative, current
     * has flowed from the EV to the grid. Defined in A (Ampere).
     */
    MIN_CURRENT("MIN_CURRENT"),
    /**
     * Maximum power reached during this ChargingPeriod: defined in kW (Kilowatt).
     */
    MAX_POWER("MAX_POWER"),
    /**
     * Minimum power reached during this ChargingPeriod: defined in kW (Kilowatt), when negative, the power
     * has flowed from the EV to the grid.
     */
    MIN_POWER("MIN_POWER"),
    /**
     * Time during this ChargingPeriod not charging: defined in hours, default step_size multiplier is 1 second.
     */
    PARKING_TIME("PARKING_TIME"),
    /**
     * Average power during this ChargingPeriod: defined in kW (Kilowatt). When negative, the power
     * is flowing from the EV to the grid.
     * Session Only
     */
    POWER("POWER"),
    /**
     * Time during this ChargingPeriod Charge Point has been reserved and not yet been in use for this customer:
     * defined in hours, default step_size multiplier is 1 second.
     */
    RESERVATION_TIME("RESERVATION_TIME"),
    /**
     * Current state of charge of the EV, in percentage, values allowed: 0 to 100. See note below.
     */
    STATE_OF_CHARGE("STATE_OF_CHARGE"),
    /**
     * Time charging during this ChargingPeriod: defined in hours, default step_size multiplier is 1 second.
     * Session Only
     */
    TIME("TIME");
    private final String value;

    CdrDimensionType(String value) {
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
    public static CdrDimensionType fromValue(String value) {
        return findByField(
                CdrDimensionType.class,
                CdrDimensionType::value,
                value
        );
    }
}
