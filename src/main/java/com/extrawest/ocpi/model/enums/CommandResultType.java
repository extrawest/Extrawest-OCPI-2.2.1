package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Result of the command that was send to the Charge Point.
 */
public enum CommandResultType {
    /**
     * Command request accepted by the Charge Point.
     */
    ACCEPTED ("ACCEPTED "),
    /**
     * The Reservation has been canceled by the CPO.
     */
    CANCELED_RESERVATION ("CANCELED_RESERVATION "),
    /**
     * EVSE is currently occupied, another session is ongoing. Cannot start a new session
     */
    EVSE_OCCUPIED("EVSE_OCCUPIED"),
    /**
     * EVSE is currently inoperative or faulted.
     */
    EVSE_INOPERATIVE("EVSE_INOPERATIVE"),
    /**
     * Execution of the command failed at the Charge Point.
     */
    FAILED("FAILED"),
    /**
     * The requested command is not supported by this Charge Point, EVSE etc.
     */
    NOT_SUPPORTED("NOT_SUPPORTED"),
    /**
     * Command request rejected by the Charge Point.
     */
    REJECTED("REJECTED"),
    /**
     * Command request timeout, no response received from the Charge Point in a reasonable time.
     */
    TIMEOUT("TIMEOUT"),
    /**
     * The Reservation in the requested command is not known by this Charge Point.
     */
    UNKNOWN_RESERVATION("UNKNOWN_RESERVATION");
    private final String value;

    CommandResultType(String value) {
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
    public static CommandResultType fromValue(String value) {
        return EnumUtil.findByField(
                CommandResultType.class,
                CommandResultType::value,
                value
        );
    }
}
