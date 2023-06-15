package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Different smart charging profile types.
 */
public enum ProfileType {
    /**
     * Driver wants to use the cheapest charging profile possible.
     */
    CHEAP("CHEAP"),
    /**
     * Driver wants his EV charged as quickly as possible and is willing to pay a premium for this, if needed.
     */
    FAST("FAST"),
    /**
     * Driver wants his EV charged with as much regenerative (green) energy as possible.
     */
    GREEN("GREEN"),
    /**
     * Driver does not have special preferences.
     */
    REGULAR("REGULAR");
    private final String value;

    ProfileType(String value) {
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
    public static ProfileType fromValue(String value) {
        return EnumUtil.findByField(
                ProfileType.class,
                ProfileType::value,
                value
        );
    }
}
