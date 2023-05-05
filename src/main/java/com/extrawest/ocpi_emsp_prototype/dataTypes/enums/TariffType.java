package com.extrawest.ocpi_emsp_prototype.dataTypes.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.extrawest.ocpi_emsp_prototype.util.EnumUtil.findByField;

public enum TariffType {
    /**
     *Used to describe that a Tariff is valid when ad-hoc payment is used at the Charge Point (for example:
     * Debit or Credit card payment terminal)
     */
    AD_HOC_PAYMENT("AD_HOC_PAYMENT"),
    /**
     * Used to describe that a Tariff is valid when Charging Preference: CHEAP is set for the session.
     */
    PROFILE_CHEAP("PROFILE_CHEAP"),
    /**
     *Used to describe that a Tariff is valid when Charging Preference: FAST is set for the session.
     */
    PROFILE_FAST("PROFILE_FAST"),
    /**
     *Used to describe that a Tariff is valid when Charging Preference: GREEN is set for the session.
     */
    REGULAR("REGULAR"),
    /**
     *Used to describe that a Tariff is valid when using an RFID, without any Charging Preference, or
     * when Charging Preference: REGULAR is set for the session.
     */
    PROFILE_GREEN("PROFILE_GREEN");
    private final String value;

    TariffType(String value) {
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
    public static TariffType fromValue(String value) {
        return findByField(
                TariffType.class,
                TariffType::value,
                value
        );
    }
}
