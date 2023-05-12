package com.extrawest.ocpi_emsp_prototype.dataTypes;

import com.extrawest.ocpi_emsp_prototype.dataTypes.enums.EnergySourceCategory;
import com.extrawest.ocpi_emsp_prototype.validation.RequiredValidator;
import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnergySource implements Validatable {

    @JsonIgnore
    private final transient Validator requiredValidator = new RequiredValidator();

    /**
     * The type of energy source.
     */
    private EnergySourceCategory source;
    /**
     * Percentage of this source (0-100) in the mix.
     */
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
                &&requiredValidator.safeValidate(percentage);
    }
}
