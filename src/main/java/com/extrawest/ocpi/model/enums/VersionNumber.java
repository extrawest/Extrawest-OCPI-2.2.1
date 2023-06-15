package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * List of known versions.
 */
public enum VersionNumber {
    /**
     * OCPI version 2.0
     */
    V_2_0("2.0"),
    /**
     * OCPI version 2.1 (DEPRECATED, do not use, use 2.1.1 instead)
     */
    V_2_1("2.1"),
    /**
     * OCPI version 2.1.1
     */
    V_2_1_1("2.1.1"),
    /**
     * OCPI version 2.2 (DEPRECATED, do not use, use 2.2.1 instead)
     */
    V_2_2("2.2"),
    /**
     * OCPI version 2.2.1 (this version)
     */
    V_2_2_1("2.2.1");
    private final String value;

    VersionNumber(String value) {
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
    public static VersionNumber fromValue(String value) {
        return EnumUtil.findByField(
                VersionNumber.class,
                VersionNumber::value,
                value
        );
    }
}
