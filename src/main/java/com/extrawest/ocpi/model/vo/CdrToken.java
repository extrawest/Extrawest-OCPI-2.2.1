package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.TokenType;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CdrToken implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonIgnore
    private final Validator countryCodeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string2())
                    .build();

    @JsonIgnore
    private final Validator partyIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();

    @JsonIgnore
    private final Validator uidValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * ISO-3166 alpha-2 country code of the MSP that 'owns' this Token.
     */
    @JsonProperty("country_code")
    private String countryCode;
    /**
     * ID of the eMSP that 'owns' this Token (following the ISO-15118 standard).
     */
    @JsonProperty("party_id")
    private String partyId;

    /**
     * Unique ID by which this Token can be identified. This is the field used by the CPO’s system
     * (RFID reader on the Charge Point) to identify this token. Currently, in most cases: type=RFID,
     * this is the RFID hidden ID as read by the RFID reader, but that is not a requirement.
     * If this is a type=APP_USER Token, it will be a unique, by the eMSP, generated ID.
     */
    @JsonProperty("uid")
    private String uid;

    /**
     * Type of the token
     */
    @JsonProperty("type")
    private TokenType type;

    /**
     * Uniquely identifies the EV driver contract token within the eMSP’s platform (and suboperator platforms).
     * Recommended to follow the specification for eMA ID from "eMI3 standard version
     * V1.0" (<a href="http://emi3group.com/documents-links/">...</a>) "Part 2: business objects."
     */
    @JsonProperty("contract_id")
    private String contractId;

    public void setCountryCode(String countryCode) {
        countryCodeValidator.validate(countryCode);
        this.countryCode = countryCode;
    }

    public void setPartyId(String partyId) {
        partyIdValidator.validate(partyId);
        this.partyId = partyId;
    }

    public void setUid(String uid) {
        uidValidator.validate(uid);
        this.uid = uid;
    }

    public void setType(TokenType type) {
        requiredValidator.validate(type);
        this.type = type;
    }

    public void setContractId(String contractId) {
        requiredValidator.validate(contractId);
        this.contractId = contractId;
    }

    @Override
    public boolean validate() {
        return countryCodeValidator.safeValidate(countryCode)
                && partyIdValidator.safeValidate(partyId)
                && uidValidator.safeValidate(uid)
                && requiredValidator.safeValidate(type)
                && requiredValidator.safeValidate(contractId);
    }
}
