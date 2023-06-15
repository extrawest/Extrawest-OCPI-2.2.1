package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PowerType {
    /**
     * AC single phase
     */
    AC_1_PHASE("AC_1_PHASE"),
    /**
     * AC two phases, only two of the three available phases connected.
     */
    AC_2_PHASE("AC_2_PHASE"),
    /**
     * AC two phases using split phase system.
     */
    AC_2_PHASE_SPLIT("AC_2_PHASE_SPLIT"),
    /**
     * AC two phases using split phase system.
     */
    AC_3_PHASE("AC_3_PHASE"),
    /**
     * Direct Current.
     */
    DC("DC");
    private final String value;

    PowerType(String value) {
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
    public static PowerType fromValue(String value) {
        return EnumUtil.findByField(
                PowerType.class,
                PowerType::value,
                value
        );
    }
}
