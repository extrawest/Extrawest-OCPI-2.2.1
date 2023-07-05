package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Digits;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Price implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Price/Cost excluding VAT.
     */
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float exclVat;
    /**
     * Price/Cost including VAT.
     */
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float inclVat;

    public Price(float exclVat) {
        requiredValidator.validate(exclVat);
        this.exclVat = exclVat;
    }

    public void setExclVat(Float exclVat) {
        requiredValidator.validate(exclVat);
        this.exclVat = exclVat;
    }

    public void setInclVat(Float inclVat) {
        this.inclVat = inclVat;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(exclVat);
    }
}
