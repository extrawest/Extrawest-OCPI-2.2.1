package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.AllowedType;
import com.extrawest.ocpi.model.vo.DisplayText;
import com.extrawest.ocpi.model.vo.LocationReferences;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class AuthorizationInfo implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonIgnore
    private final Validator authorizationReferenceValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string36())
                    .build();

    /**
     * Status of the Token, and whether charging is allowed at the optionally given location.
     */
    @JsonProperty("allowed")
    private AllowedType allowed;

    /**
     * The complete Token object for which this authorization was requested.
     */
    @JsonProperty("token")
    private Token token;

    /**
     * Optional reference to the location if it was included in the request, and if the EV driver is allowed to charge
     * at that location. Only the EVSEs the EV driver is allowed to charge at are returned.
     */
    @JsonProperty("location")
    private LocationReferences location;

    /**
     * Reference to the authorization given by the eMSP, when given, this reference will be provided in the
     * relevant Session and/or CDR.
     */
    @JsonProperty("authorization_reference")
    private String authorizationReference;

    /**
     * Optional display text, additional information to the EV driver.
     */
    @JsonProperty("info")
    private DisplayText info;

    public void setAllowed(AllowedType allowed) {
        requiredValidator.validate(allowed);
        this.allowed = allowed;
    }

    public void setToken(Token token) {
        requiredValidator.validate(token);
        this.token = token;
    }

    public void setLocation(LocationReferences location) {
        this.location = location;
    }

    public void setAuthorizationReference(String authorizationReference) {
        authorizationReferenceValidator.validate(authorizationReference);
        this.authorizationReference = authorizationReference;
    }

    public void setInfo(DisplayText info) {
        this.info = info;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(allowed)
                && requiredValidator.safeValidate(token)
                && token.validate();
    }
}
