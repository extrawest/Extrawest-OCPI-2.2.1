package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.ValidationRules;
import com.extrawest.ocpi.validation.Validator;
import com.extrawest.ocpi.validation.ValidatorBuilder;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class defines the geo location of the Charge Point. The geodetic system to be used is WGS 84.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class GeoLocation implements Validatable {

    @JsonIgnore
    private final Validator latitudeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string10())
                    .build();
    @JsonIgnore
    private final Validator longitudeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string11())
                    .build();

    /**
     * Latitude of the point in decimal degree. Example: 50.770774. Decimal separator: "."
     * Regex: -?[0-9]{1,2}\.[0-9]{5,7}
     */
    @JsonProperty("latitude")
    private String latitude;
    /**
     * Longitude of the point in decimal degree. Example: -126.104965. Decimal separator: "."
     * Regex: -?[0-9]{1,3}\.[0-9]{5,7}
     */
    @JsonProperty("longitude")
    private String longitude;

    public void setLatitude(String latitude) {
        latitudeValidator.validate(latitude);
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        longitudeValidator.validate(longitude);
        this.longitude = longitude;
    }

    @Override
    public boolean validate() {
        return latitudeValidator.safeValidate(latitude)
                && longitudeValidator.safeValidate(longitude);
    }
}
