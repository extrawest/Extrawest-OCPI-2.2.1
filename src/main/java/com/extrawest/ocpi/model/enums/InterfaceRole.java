package com.extrawest.ocpi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi.util.EnumUtil.findByField;

public enum InterfaceRole {
    /**
     * Sender Interface implementation. Interface implemented by the owner of data, so the Receiver can
     * Pull information from the data Sender/owner.
     */
    SENDER("SENDER"),
    /**
     * Receiver Interface implementation. Interface implemented by the receiver of data, so the
     * Sender/owner can Push information to the Receiver.
     */
    RECEIVER("RECEIVER");
    private final String value;

    InterfaceRole(String value) {
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
    public static InterfaceRole fromValue(String value) {
        return findByField(
                InterfaceRole.class,
                InterfaceRole::value,
                value
        );
    }
}
