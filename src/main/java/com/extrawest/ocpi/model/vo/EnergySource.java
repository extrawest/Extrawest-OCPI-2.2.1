package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.EnergySourceCategory;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnergySource implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * The type of energy source.
     */
    @JsonProperty("source")
    private EnergySourceCategory source;
    /**
     * Percentage of this source (0-100) in the mix.
     */
    @JsonProperty("percentage")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float percentage;

    public EnergySource(EnergySourceCategory source, Float percentage) {
        requiredValidator.validate(source);
        requiredValidator.validate(percentage);
        this.source = source;
        this.percentage = percentage;
    }

    public void setSource(EnergySourceCategory source) {
        requiredValidator.validate(source);
        this.source = source;
    }

    public void setPercentage(Float percentage) {
        requiredValidator.validate(percentage);
        this.percentage = percentage;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(source)
                && requiredValidator.safeValidate(percentage);
    }
}
