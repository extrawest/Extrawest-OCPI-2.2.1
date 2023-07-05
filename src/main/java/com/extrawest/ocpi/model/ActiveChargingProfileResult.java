package com.extrawest.ocpi.model;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.model.enums.ChargingProfileResultType;
import com.extrawest.ocpi.model.vo.ActiveChargingProfile;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The ActiveChargingProfileResult object is send by the CPO to the given response_url in a POST request.
 * It contains the result of the GET (ActiveChargingProfile) request send by the eMSP.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ActiveChargingProfileResult extends AbstractProfileResult implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * The requested ActiveChargingProfile, if the result field is set to: ACCEPTED
     */
    @JsonProperty("profile")
    private ActiveChargingProfile profile;

    public void setResult(ChargingProfileResultType result) {
        requiredValidator.validate(result);
        this.result = result;
    }

    public void setProfile(ActiveChargingProfile profile) {
        this.profile = profile;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(result);
    }
}
