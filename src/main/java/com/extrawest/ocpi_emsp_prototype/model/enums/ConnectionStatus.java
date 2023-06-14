package com.extrawest.ocpi_emsp_prototype.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi_emsp_prototype.util.EnumUtil.findByField;

public enum ConnectionStatus {
    /**
     * Party is connected.
     */
    CONNECTED("CONNECTED"),
    /**
     * Party is currently not connected.
     */
    OFFLINE("OFFLINE"),
    /**
     * Connection to this party is planned, but has never been connected.
     */
    PLANNED("PLANNED"),
    /**
     * Party is now longer active, will never connect anymore.
     */
    SUSPENDED("SUSPENDED");
    private final String value;

    ConnectionStatus(String value) {
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
    public static ConnectionStatus fromValue(String value) {
        return findByField(
                ConnectionStatus.class,
                ConnectionStatus::value,
                value
        );
    }
}
