package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines when authorization of a Token by the CPO is allowed.
 */
public enum WhitelistType {
    /**
     * Token always has to be whitelisted, realtime authorization is not possible/allowed. CPO shall always allow
     * any use of this Token.
     */
    ALWAYS("ALWAYS"),
    /**
     * It is allowed to whitelist the token, realtime authorization is also allowed. The CPO may choose which version
     * of authorization to use.
     */
    ALLOWED("ALLOWED"),
    /**
     * In normal situations realtime authorization shall be used. But when the CPO cannot get a response from the eMSP
     * (communication between CPO and eMSP is offline), the CPO shall allow this Token to be used.
     */
    ALLOWED_OFFLINE("ALLOWED_OFFLINE"),
    /**
     * Whitelisting is forbidden, only realtime authorization is allowed. CPO shall always send a realtime
     * authorization for any use of this Token to the eMSP.
     */
    NEVER("NEVER");
    private final String value;

    WhitelistType(String value) {
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
    public static WhitelistType fromValue(String value) {
        return EnumUtil.findByField(
                WhitelistType.class,
                WhitelistType::value,
                value
        );
    }
}
