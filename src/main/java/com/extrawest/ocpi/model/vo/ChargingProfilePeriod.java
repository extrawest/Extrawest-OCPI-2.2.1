package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Charging profile period structure defines a time period in a charging profile, as used in: ChargingProfile
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ChargingProfilePeriod implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Start of the period, in seconds from the start of profile.
     * The value of StartPeriod also defines the stop time of the previous period.
     */
    @JsonProperty("start_period")
    private Integer startPeriod;

    /**
     * Charging rate limit during the profile period, in the applicable chargingRateUnit, for example in Amperes (A)
     * or Watts (W). Accepts at most one digit fraction (e.g. 8.1).
     */
    @JsonProperty("limit")
    private Float limit;

    public void setStartPeriod(Integer startPeriod) {
        requiredValidator.validate(startPeriod);
        this.startPeriod = startPeriod;
    }

    public void setLimit(Float limit) {
        requiredValidator.validate(limit);
        this.limit = limit;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(startPeriod)
                && requiredValidator.safeValidate(limit);
    }
}
