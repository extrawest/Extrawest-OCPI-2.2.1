package com.extrawest.ocpi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi.util.EnumUtil.findByField;

public enum EnergySourceCategory {
    /**
     * Nuclear power sources.
     */
    NUCLEAR("NUCLEAR"),
    /**
     * All kinds of fossil power sources.
     */
    GENERAL_FOSSIL("GENERAL_FOSSIL"),
    /**
     * Fossil power from coal.
     */
    COAL("COAL"),
    /**
     * Fossil power from gas.
     */
    GAS("GAS"),
    /**
     * All kinds of regenerative power sources.
     */
    GENERAL_GREEN("GENERAL_GREEN"),
    /**
     * Regenerative power from PV.
     */
    SOLAR("SOLAR"),
    /**
     * Regenerative power from wind turbines.
     */
    WIND("WIND"),
    /**
     * Regenerative power from water turbines.
     */
    WATER("WATER");
    private final String value;

    EnergySourceCategory(String value) {
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
    public static EnergySourceCategory fromValue(String value) {
        return findByField(
                EnergySourceCategory.class,
                EnergySourceCategory::value,
                value
        );
    }
}
