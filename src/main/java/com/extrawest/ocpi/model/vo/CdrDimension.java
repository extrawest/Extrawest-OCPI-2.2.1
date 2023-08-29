package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.CdrDimensionType;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CdrDimension implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Type of CDR dimension.
     */
    @JsonProperty("type")
    private CdrDimensionType type;

    /**
     * Volume of the dimension consumed, measured according to the dimension type.
     */
    @JsonProperty("volume")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float volume;

    public void setType(CdrDimensionType type) {
        requiredValidator.validate(type);
        this.type = type;
    }

    public void setVolume(Float volume) {
        requiredValidator.validate(volume);
        this.volume = volume;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(type)
                && requiredValidator.safeValidate(volume);
    }
}
