package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.model.enums.TariffDimensionType;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Digits;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PriceComponent implements Validatable {

    @JsonIgnore
    private final Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * Type of tariff dimension.
     */
    private TariffDimensionType type;
    /**
     * Price per unit (excl. VAT) for this tariff dimension.
     */
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float price;
    /**
     * Applicable VAT percentage for this tariff dimension. If omitted, no VAT is applicable.
     * Not providing a VAT is different from 0% VAT, which would be a value of 0.0 here.
     */
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float vat;
    /**
     * Minimum amount to be billed. This unit will be billed in this step_size blocks.
     * Amounts that are less then this step_size are rounded up to the given step_size.
     * For example: if type is TIME and step_size has a value of 300, then time will be billed in blocks of 5 minutes.
     * If 6 minutes were used, 10 minutes (2 blocks of step_size) will be billed.
     */
    private int step_size;

    public void setType(TariffDimensionType type) {
        requiredValidator.validate(type);
        this.type = type;
    }

    public void setPrice(Float price) {
        requiredValidator.validate(price);
        this.price = price;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public void setStep_size(int step_size) {
        requiredValidator.validate(step_size);
        this.step_size = step_size;
    }

    public PriceComponent(TariffDimensionType type, Float price, int step_size) {
        requiredValidator.validate(type);
        requiredValidator.validate(price);
        requiredValidator.validate(step_size);
        this.type = type;
        this.price = price;
        this.step_size = step_size;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(type)
                && requiredValidator.safeValidate(price)
                && requiredValidator.safeValidate(step_size);
    }
}
