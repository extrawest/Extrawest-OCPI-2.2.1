package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.vo.ChargingProfile;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Object set to a CPO to set a Charging Profile.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SetChargingProfile implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonIgnore
    private final Validator responseUrlValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();

    /**
     * Contains limits for the available power or current over time.
     */
    @JsonProperty("charging_profile")
    private ChargingProfile chargingProfile;

    /**
     * URL that the ChargingProfileResult POST should be send to. This URL might contain an unique ID to be able
     * to distinguish between GET ActiveChargingProfile requests.
     */
    @JsonProperty("response_url ")
    private String responseUrl;

    public void setChargingProfile(ChargingProfile chargingProfile) {
        requiredValidator.validate(chargingProfile);
        this.chargingProfile = chargingProfile;
    }

    public void setResponseUrl(String responseUrl) {
        responseUrlValidator.validate(responseUrl);
        this.responseUrl = responseUrl;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(chargingProfile)
                && responseUrlValidator.safeValidate(responseUrl);
    }
}
