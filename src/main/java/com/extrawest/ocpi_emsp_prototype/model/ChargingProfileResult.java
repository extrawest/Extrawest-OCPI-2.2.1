package com.extrawest.ocpi_emsp_prototype.model;

import com.extrawest.ocpi_emsp_prototype.model.enums.ChargingProfileResultType;
import com.extrawest.ocpi_emsp_prototype.validation.RequiredValidator;
import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The ChargingProfileResult object is send by the CPO to the given response_url in a POST request.
 * It contains the result of the PUT (SetChargingProfile) request send by the eMSP.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ChargingProfileResult extends AbstractProfileResult implements Validatable {

    @JsonIgnore
    private final transient Validator requiredValidator = new RequiredValidator();

    public void setResult(ChargingProfileResultType result) {
        requiredValidator.validate(result);
        this.result = result;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(result);
    }
}
