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

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ActiveChargingProfile implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Date and time at which the Charge Point has calculated this ActiveChargingProfile.
     * All time measurements within the profile are relative to this timestamp.
     */
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;

    /**
     * Charging profile structure defines a list of charging periods.
     */
    @JsonProperty("charging_profile")
    private ChargingProfile chargingProfile;

    public void setStartDateTime(LocalDateTime startDateTime) {
        requiredValidator.validate(startDateTime);
        this.startDateTime = startDateTime;
    }

    public void setChargingProfile(ChargingProfile chargingProfile) {
        requiredValidator.validate(chargingProfile);
        this.chargingProfile = chargingProfile;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(startDateTime)
                && requiredValidator.safeValidate(chargingProfile)
                && chargingProfile.validate();
    }
}
