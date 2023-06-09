package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.ChargingProfileResultType;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The ClearProfileResult object is send by the CPO to the given response_url in a POST request.
 * It contains the result of the DELETE (ClearProfile) request send by the eMSP
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ClearProfileResult extends AbstractProfileResult implements Validatable {

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
