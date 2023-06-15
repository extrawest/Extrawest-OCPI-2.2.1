package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Unit in which a charging profile is defined.
 */
public enum ChargingRateUnit {
    /**
     * Watts (power) This is the TOTAL allowed charging power. If used for AC Charging, the phase current should be
     * calculated via: Current per phase = Power / (Line Voltage * Number of Phases). The "Line Voltage" used in the
     * calculation is the Line to Neutral Voltage (VLN). In Europe and Asia VLN is typically 220V or 230V and the
     * corresponding Line to Line Voltage (VLL) is 380V and 400V. The "Number of Phases" is the numberPhases from the
     * ChargingProfilePeriod. It is usually more convenient to use this for DC charging. Note that if numberPhases
     * in a ChargingProfilePeriod is absent, 3 SHALL be assumed.
     */
    W("W"),
    /**
     * Amperes (current) The amount of Ampere per phase, not the sum of all phases. It is usually more convenient to use
     * this for AC charging.
     */
    A("A");
    private final String value;

    ChargingRateUnit(String value) {
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
    public static ChargingRateUnit fromValue(String value) {
        return EnumUtil.findByField(
                ChargingRateUnit.class,
                ChargingRateUnit::value,
                value
        );
    }
}
