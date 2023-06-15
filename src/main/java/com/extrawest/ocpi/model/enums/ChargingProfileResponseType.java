package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Response to the ChargingProfile request from the eMSP to the CPO.
 */
public enum ChargingProfileResponseType {
    /**
     * ChargingProfile request accepted by the CPO, request will be forwarded to the EVSE.
     */
    ACCEPTED("ACCEPTED"),
    /**
     * The ChargingProfiles not supported by this CPO, Charge Point, EVSE etc.
     */
    NOT_SUPPORTED("NOT_SUPPORTED"),
    /**
     * ChargingProfile request rejected by the CPO.
     * (Session might not be from a customer of the eMSP that send this request)
     */
    REJECTED("REJECTED"),
    /**
     * ChargingProfile request rejected by the CPO, requests are send more often then allowed.
     */
    TOO_OFTEN("TOO_OFTEN"),
    /**
     * The Session in the requested command is not known by this CPO.
     */
    UNKNOWN_SESSION("UNKNOWN_SESSION");
    private final String value;

    ChargingProfileResponseType(String value) {
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
    public static ChargingProfileResponseType fromValue(String value) {
        return EnumUtil.findByField(
                ChargingProfileResponseType.class,
                ChargingProfileResponseType::value,
                value
        );
    }
}
