package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Response to the command request from the eMSP to the CPO.
 */
public enum CommandResponseType {
    /**
     * The requested command is not supported by this CPO, Charge Point, EVSE etc.
     */
    NOT_SUPPORTED("NOT_SUPPORTED"),
    /**
     * Command request rejected by the CPO. (Session might not be from a customer of the eMSP that send this request)
     */
    REJECTED("REJECTED"),
    /**
     * Command request accepted by the CPO.
     */
    ACCEPTED("ACCEPTED"),
    /**
     * The Session in the requested command is not known by this CPO.
     */
    UNKNOWN_SESSION("UNKNOWN_SESSION");
    private final String value;

    CommandResponseType(String value) {
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
    public static CommandResponseType fromValue(String value) {
        return EnumUtil.findByField(
                CommandResponseType.class,
                CommandResponseType::value,
                value
        );
    }
}
