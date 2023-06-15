package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Result of a ChargingProfile request that the EVSE sends via the CPO to the eMSP.
 */
public enum ChargingProfileResultType {
    /**
     * ChargingProfile request accepted by the EVSE.
     */
    ACCEPTED("ACCEPTED"),
    /**
     * ChargingProfile request rejected by the EVSE.
     */
    REJECTED("REJECTED"),
    /**
     * No Charging Profile(s) were found by the EVSE matching the request.
     */
    UNKNOWN("UNKNOWN");
    private final String value;

    ChargingProfileResultType(String value) {
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
    public static ChargingProfileResultType fromValue(String value) {
        return EnumUtil.findByField(
                ChargingProfileResultType.class,
                ChargingProfileResultType::value,
                value
        );
    }
}
