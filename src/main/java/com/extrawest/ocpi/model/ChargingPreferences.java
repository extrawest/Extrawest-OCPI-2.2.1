package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.ProfileType;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Contains the charging preferences of an EV driver.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ChargingPreferences implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Type of Smart Charging Profile selected by the driver. The ProfileType has to be supported at the Connector
     * and for every supported ProfileType, a Tariff MUST be provided. This gives the EV driver the option between
     * different pricing options.
     */
    @JsonProperty("profile_type")
    private ProfileType profileType;

    /**
     * Expected departure. The driver has given this Date/Time as expected departure moment. It is only an estimation
     * and not necessarily the Date/Time of the actual departure.
     */
    @JsonProperty("departure_time")
    private LocalDateTime departureTime;

    /**
     * Requested amount of energy in kWh. The EV driver wants to have this amount
     * of energy charged.
     */
    @JsonProperty("energyNeed")
    private Float energyNeed;

    /**
     * The driver allows their EV to be discharged when needed, as long as the other preferences are met: EV is charged
     * with the preferred energy (energy_need) until the preferred departure moment (departure_time).
     * Default if omitted: false
     */
    @JsonProperty("discharge_allowed")
    private Boolean dischargeAllowed = false;

    public void setProfileType(ProfileType profileType) {
        requiredValidator.validate(profileType);
        this.profileType = profileType;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setEnergyNeed(Float energyNeed) {
        this.energyNeed = energyNeed;
    }

    public void setDischargeAllowed(Boolean dischargeAllowed) {
        this.dischargeAllowed = dischargeAllowed;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(profileType);
    }
}
