package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Different smart charging profile types.
 */
public enum ChargingPreferencesResponse {
    /**
     * Charging Preferences accepted, EVSE will try to accomplish them, although this is no guarantee that they will be
     * fulfilled.
     */
    ACCEPTED("ACCEPTED"),
    /**
     * CPO requires departure_time to be able to perform Charging Preference based Smart Charging.
     */
    DEPARTURE_REQUIRED("DEPARTURE_REQUIRED"),
    /**
     * CPO requires energy_need to be able to perform Charging Preference based Smart Charging.
     */
    ENERGY_NEED_REQUIRED("ENERGY_NEED_REQUIRED"),
    /**
     * Charging Preferences contain a demand that the EVSE knows it cannot fulfill.
     */
    NOT_POSSIBLE("NOT_POSSIBLE"),
    /**
     * profile_type contains a value that is not supported by the EVSE.
     */
    PROFILE_TYPE_NOT_SUPPORTED("PROFILE_TYPE_NOT_SUPPORTED");
    private final String value;

    ChargingPreferencesResponse(String value) {
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
    public static ChargingPreferencesResponse fromValue(String value) {
        return EnumUtil.findByField(
                ChargingPreferencesResponse.class,
                ChargingPreferencesResponse::value,
                value
        );
    }
}
