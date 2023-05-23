package com.extrawest.ocpi_emsp_prototype.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi_emsp_prototype.util.EnumUtil.findByField;

public enum ConnectorFormat {
    /**
     * The connector is a socket; the EV user needs to bring a fitting plug.
     */
    SOCKET("SOCKET"),
    /**
     * The connector is an attached cable; the EV users car needs to have a fitting inlet.
     */
    CABLE("CABLE");
    private final String value;

    ConnectorFormat(String value) {
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
    public static ConnectorFormat fromValue(String value) {
        return findByField(
                ConnectorFormat.class,
                ConnectorFormat::value,
                value
        );
    }
}
