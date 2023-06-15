package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The Module identifiers for each endpoint are described in the beginning of each Module chapter.
 * The following table contains the list of modules in this version of OCPI.
 * Most modules (except Credentials & Registration) are optional, but there might be dependencies between modules.
 * If there are dependencies between modules, it will be mentioned in the affected module description.
 */
public enum ModuleID {
    CDRS("cdrs"),
    CHARGING_PROFILES("chargingprofiles"),
    COMMANDS("commands"),
    /**
     * Required for all implementations.
     * The role field has no function for this module.
     */
    CREDENTIALS("credentials"),
    HUB_CLIENT_INFO("hubclientinfo"),
    LOCATIONS("locations"),
    SESSIONS("sessions"),
    TARIFFS("tariffs"),
    TOKENS("tokens");
    private final String value;

    ModuleID(String value) {
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
    public static ModuleID fromValue(String value) {
        return EnumUtil.findByField(
                ModuleID.class,
                ModuleID::value,
                value
        );
    }
}
