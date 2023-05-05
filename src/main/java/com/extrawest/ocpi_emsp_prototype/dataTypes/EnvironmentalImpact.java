package com.extrawest.ocpi_emsp_prototype.dataTypes;

import com.extrawest.ocpi_emsp_prototype.dataTypes.enums.EnvironmentalImpactCategory;
import com.extrawest.ocpi_emsp_prototype.validation.RequiredValidator;
import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnvironmentalImpact implements Validatable {

    private final transient Validator requiredValidator = new RequiredValidator();

    /**
     * The environmental impact category of this value.
     */
    private EnvironmentalImpactCategory category;
    /**
     * Amount of this portion in g/kWh.
     */
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
                &&requiredValidator.safeValidate(amount);
    }
}
