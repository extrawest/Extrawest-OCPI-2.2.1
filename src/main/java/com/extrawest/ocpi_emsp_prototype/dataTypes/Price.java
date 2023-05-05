package com.extrawest.ocpi_emsp_prototype.dataTypes;

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
public class Price implements Validatable {

    private final transient Validator requiredValidator = new RequiredValidator();

    /**
     * Price/Cost excluding VAT.
     */
    private Float excl_vat;
    /**
     * Price/Cost including VAT.
     */
    private Float incl_vat;

    public Price(float excl_vat) {
        requiredValidator.validate(excl_vat);
        this.excl_vat = excl_vat;
    }

    public void setExcl_vat(Float excl_vat) {
        requiredValidator.validate(excl_vat);
        this.excl_vat = excl_vat;
    }

    public void setIncl_vat(Float incl_vat) {
        this.incl_vat = incl_vat;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(excl_vat);
    }
}
