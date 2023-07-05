package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.Role;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsRole implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();
    @JsonIgnore
    private final Validator partyIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();
    @JsonIgnore
    private final Validator countryCodeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string2())
                    .build();

    /**
     * Type of role.
     */
    @JsonProperty("role")
    private Role role;
    /**
     * Details of this party.
     */
    @JsonProperty("business_details")
    private BusinessDetails businessDetails;
    /**
     * CPO, eMSP (or other role) ID of this party (following the ISO-15118 standard).
     */
    @JsonProperty("party_id")
    private String partyId;
    /**
     * ISO-3166 alpha-2 country code of the country this party is operating in.
     */
    @JsonProperty("country_code")
    private String countryCode;

    public void setRole(Role role) {
        requiredValidator.validate(role);
        this.role = role;
    }

    public void setBusinessDetails(BusinessDetails businessDetails) {
        requiredValidator.validate(businessDetails);
        this.businessDetails = businessDetails;
    }

    public void setPartyId(String partyId) {
        partyIdValidator.validate(partyId);
        this.partyId = partyId;
    }

    public void setCountryCode(String countryCode) {
        countryCodeValidator.validate(countryCode);
        this.countryCode = countryCode;
    }

    @Override
    public boolean validate() {
        return countryCodeValidator.safeValidate(countryCode)
                && partyIdValidator.safeValidate(partyId)
                && requiredValidator.safeValidate(role)
                && requiredValidator.safeValidate(businessDetails)
                && businessDetails.validate();
    }
}
