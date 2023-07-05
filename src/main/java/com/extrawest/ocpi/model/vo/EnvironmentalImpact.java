package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.EnvironmentalImpactCategory;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Digits;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnvironmentalImpact implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * The environmental impact category of this value.
     */
    private EnvironmentalImpactCategory category;
    /**
     * Amount of this portion in g/kWh.
     */
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float amount;

    public EnvironmentalImpact(EnvironmentalImpactCategory category, Float amount) {
        requiredValidator.validate(category);
        requiredValidator.validate(amount);
        this.category = category;
        this.amount = amount;
    }

    public void setCategory(EnvironmentalImpactCategory category) {
        requiredValidator.validate(category);
        this.category = category;
    }

    public void setAmount(Float amount) {
        requiredValidator.validate(amount);
        this.amount = amount;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(category)
                && requiredValidator.safeValidate(amount);
    }
}
