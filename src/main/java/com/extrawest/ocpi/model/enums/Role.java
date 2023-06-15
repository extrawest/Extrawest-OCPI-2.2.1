package com.extrawest.ocpi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi.util.EnumUtil.findByField;

public enum Role {
    /**
     * Charge Point Operator Role.
     */
    CPO("CPO"),
    /**
     * eMobility Service Provider Role.
     */
    EMSP("EMSP"),
    /**
     * Hub role.
     */
    HUB("HUB"),
    /**
     * National Access Point Role (national Database with all Location information of a country).
     */
    NAP("NAP"),
    /**
     * Navigation Service Provider Role, role like an eMSP (probably only interested in Location information).
     */
    NSP("NSP"),
    /**
     * Other role.
     */
    OTHER("OTHER"),
    /**
     * Smart Charging Service Provider Role.
     */
    SCSP("SCSP");
    private final String value;

    Role(String value) {
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
    public static Role fromValue(String value) {
        return findByField(
                Role.class,
                Role::value,
                value
        );
    }
}
