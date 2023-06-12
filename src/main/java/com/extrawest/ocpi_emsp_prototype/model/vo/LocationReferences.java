package com.extrawest.ocpi_emsp_prototype.model.vo;

import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.ValidationRules;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.extrawest.ocpi_emsp_prototype.validation.ValidatorBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * References to location details.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class LocationReferences implements Validatable {

    @JsonIgnore
    private final transient Validator locationIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * Unique identifier for the location.
     */
    @JsonProperty("location_id")
    private String locationId;

    /**
     * Unique identifiers for EVSEs within the CPO’s platform for the EVSE within the given location.
     */
    @JsonProperty("evse_uids")
    private List<String> evseUids;

    public void setLocationId(String locationId) {
        locationIdValidator.validate(locationId);
        this.locationId = locationId;
    }

    public void setEvseUids(List<String> evseUids) {
        this.evseUids = evseUids;
    }

    @Override
    public boolean validate() {
        return locationIdValidator.safeValidate(locationId);
    }
}
