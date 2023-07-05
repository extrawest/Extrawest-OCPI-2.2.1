package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.ProfileType;
import com.extrawest.ocpi.model.enums.TokenType;
import com.extrawest.ocpi.model.enums.WhitelistType;
import com.extrawest.ocpi.model.vo.EnergyContract;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Token implements Validatable {

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

    @JsonIgnore
    private final Validator contractIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator visualNumberValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string64())
                    .build();

    @JsonIgnore
    private final Validator issuerValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string64())
                    .build();

    @JsonIgnore
    private final Validator groupIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator languageValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string2())
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
     * Unique ID by which this Token, combined with the Token type, can be identified.
     * This is the field used by CPO system (RFID reader on the Charge Point) to identify this token.
     * Currently, in most cases: type=RFID, this is the RFID hidden ID as read by the RFID reader, but that is not
     * a requirement. If this is a APP_USER or AD_HOC_USER Token, it will be a uniquely, by the eMSP, generated ID.
     * This field is named uid instead of id to prevent confusion with: contract_id.
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

    /**
     * Visual readable number/identification as printed on the Token (RFID card), might be equal to the contract_id.
     */
    @JsonProperty("visual_number")
    private String visualNumber;

    /**
     * Issuing company, most of the time the name of the company printed on the token (RFID card), not necessarily the eMSP.
     */
    @JsonProperty("issuer")
    private String issuer;

    /**
     * This ID groups a couple of tokens. This can be used to make two or more tokens work as one,
     * so that a session can be started with one token and stopped with another, handy when a card and key-fob
     * are given to the EV-driver. Beware that OCPP 1.5/1.6 only support group_ids (it is called parentId in OCPP
     * 1.5/1.6) with a maximum length of 20.
     */
    @JsonProperty("group_id")
    private String groupId;

    /**
     * Is this Token valid
     */
    @JsonProperty("valid")
    private Boolean valid;

    /**
     * Indicates what type of white-listing is allowed.
     */
    @JsonProperty("whitelist")
    private WhitelistType whitelist;

    /**
     * Language Code ISO 639-1. This optional field indicates the Token owner’s preferred interface language.
     * If the language is not provided or not supported then the CPO is free to choose its own language
     */
    @JsonProperty("language")
    private String language;

    /**
     * The default Charging Preference. When this is provided, and a charging session is started on an Charge Point
     * that support Preference base Smart Charging and support this ProfileType, the Charge Point can start using
     * this ProfileType, without this having to be set via: Set Charging Preferences.
     */
    @JsonProperty("default_profile_type")
    private ProfileType defaultProfileType;

    /**
     * When the Charge Point supports using your own energy supplier/contract at a Charge Point,
     * information about the energy supplier/contract is needed so the CPO knows which energy supplier to use.
     * NOTE: In a lot of countries it is currently not allowed/possible to use a drivers own energy supplier/contract
     * at a Charge Point.
     */
    @JsonProperty("energy_contract")
    private EnergyContract energyContract;

    /**
     * Timestamp when this Token was last updated (or created).
     */
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;

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
        contractIdValidator.validate(contractId);
        this.contractId = contractId;
    }

    public void setVisualNumber(String visualNumber) {
        visualNumberValidator.validate(visualNumber);
        this.visualNumber = visualNumber;
    }

    public void setIssuer(String issuer) {
        issuerValidator.validate(issuer);
        this.issuer = issuer;
    }

    public void setGroupId(String groupId) {
        groupIdValidator.validate(groupId);
        this.groupId = groupId;
    }

    public void setValid(Boolean valid) {
        requiredValidator.validate(valid);
        this.valid = valid;
    }

    public void setWhitelist(WhitelistType whitelist) {
        requiredValidator.validate(whitelist);
        this.whitelist = whitelist;
    }

    public void setLanguage(String language) {
        languageValidator.validate(language);
        this.language = language;
    }

    public void setDefaultProfileType(ProfileType defaultProfileType) {
        this.defaultProfileType = defaultProfileType;
    }

    public void setEnergyContract(EnergyContract energyContract) {
        this.energyContract = energyContract;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        requiredValidator.validate(lastUpdated);
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean validate() {
        return countryCodeValidator.safeValidate(countryCode)
                && partyIdValidator.safeValidate(partyId)
                && uidValidator.safeValidate(uid)
                && requiredValidator.safeValidate(type)
                && contractIdValidator.safeValidate(contractId)
                && issuerValidator.safeValidate(issuer)
                && requiredValidator.safeValidate(valid)
                && requiredValidator.safeValidate(whitelist)
                && languageValidator.safeValidate(lastUpdated);
    }
}
