package com.extrawest.ocpi_emsp_prototype.model;

import com.extrawest.ocpi_emsp_prototype.model.enums.ChargingProfileResponseType;
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
 * The ChargingProfileResponse object is send in the HTTP response body.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ChargingProfileResponse implements Validatable {

    @JsonIgnore
    private final transient Validator requiredValidator = new RequiredValidator();

    /**
     * Response from the CPO on the ChargingProfile request.
     */
    @JsonProperty("result")
    private ChargingProfileResponseType result;

    /**
     * Timeout for this ChargingProfile request in seconds. When the Result is not received within this timeout,
     * the eMSP can assumevthat the message might never be sent.
     */
    @JsonProperty("timeout")
    private Integer timeout;

    public void setResult(ChargingProfileResponseType result) {
        requiredValidator.validate(result);
        this.result = result;
    }

    public void setTimeout(Integer timeout) {
        requiredValidator.validate(timeout);
        this.timeout = timeout;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(result)
                && requiredValidator.safeValidate(timeout);
    }
}
