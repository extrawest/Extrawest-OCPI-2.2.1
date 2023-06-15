package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines the state of a session.
 */
public enum SessionStatus {
    /**
     * The session has been accepted and is active. All pre-conditions were met: Communication between EV and EVSE
     * (for example: cable plugged in correctly), EV or driver is authorized. EV is being charged, or can be charged.
     * Energy is, or is not, being transfered.
     */
    ACTIVE("ACTIVE"),
    /**
     * The session has been finished successfully. No more modifications will be made to the Session object using this state.
     */
    COMPLETED("COMPLETED"),
    /**
     * The Session object using this state is declared invalid and will not be billed.
     */
    INVALID("INVALID"),
    /**
     * The session is pending, it has not yet started. Not all pre-conditions are met. This is the initial state.
     * The session might never become an active session.
     */
    PENDING("PENDING"),
    /**
     * The session is started due to a reservation, charging has not yet started. The session might never become
     * an active session.
     */
    RESERVATION("RESERVATION");
    private final String value;

    SessionStatus(String value) {
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
    public static SessionStatus fromValue(String value) {
        return EnumUtil.findByField(
                SessionStatus.class,
                SessionStatus::value,
                value
        );
    }
}
