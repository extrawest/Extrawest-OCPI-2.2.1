package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Capability {
    /**
     * The EVSE supports charging profiles.
     */
    CHARGING_PROFILE_CAPABLE("CHARGING_PROFILE_CAPABLE"),
    /**
     * The EVSE supports charging preferences.
     */
    CHARGING_PREFERENCES_CAPABLE("CHARGING_PREFERENCES_CAPABLE"),
    /**
     * EVSE has a payment terminal that supports chip cards.
     */
    CHIP_CARD_SUPPORT("CHIP_CARD_SUPPORT"),
    /**
     * EVSE has a payment terminal that supports contactless cards.
     */
    CONTACTLESS_CARD_SUPPORT("CONTACTLESS_CARD_SUPPORT"),
    /**
     * EVSE has a payment terminal that makes it possible to pay for charging using a credit card.
     */
    CREDIT_CARD_PAYABLE("CREDIT_CARD_PAYABLE"),
    /**
     * EVSE has a payment terminal that makes it possible to pay for charging using
     * a debit card.
     */
    DEBIT_CARD_PAYABLE("DEBIT_CARD_PAYABLE"),
    /**
     * EVSE has a payment terminal with a pin-code entry device.
     */
    PED_TERMINAL("PED_TERMINAL"),
    /**
     * EVSE has a payment terminal with a pin-code entry device.
     */
    REMOTE_START_STOP_CAPABLE("REMOTE_START_STOP_CAPABLE"),
    /**
     * EVSE has a payment terminal with a pin-code entry device.
     */
    RESERVABLE("RESERVABLE"),
    /**
     * Charging at this EVSE can be authorized with an RFID token.
     */
    RFID_READER("RFID_READER"),
    /**
     * When a StartSession is sent to this EVSE, the MSP is required to add the optional connector_id field
     * in the StartSession object.
     */
    START_SESSION_CONNECTOR_REQUIRED("START_SESSION_CONNECTOR_REQUIRED"),
    /**
     * When a StartSession is sent to this EVSE, the MSP is required to add the optional connector_id field in the
     * StartSession object.
     */
    TOKEN_GROUP_CAPABLE("TOKEN_GROUP_CAPABLE"),
    /**
     * Connectors have mechanical lock that can be requested by the eMSP to be unlocked.
     */
    UNLOCK_CAPABLE("UNLOCK_CAPABLE");
    private final String value;

    Capability(String value) {
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
    public static Capability fromValue(String value) {
        return EnumUtil.findByField(
                Capability.class,
                Capability::value,
                value
        );
    }
}
