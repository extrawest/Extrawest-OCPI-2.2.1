package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.InterfaceRole;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.model.enums.ModuleID;
import com.extrawest.ocpi.validation.*;
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
public class Endpoint implements Validatable {

    @JsonIgnore
    private final Validator urlValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();
    @JsonIgnore
    private final Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * Endpoint identifier.
     */
    @JsonProperty("identifier")
    private ModuleID identifier;
    /**
     * Interface role this endpoint implements.
     */
    @JsonProperty("role")
    private InterfaceRole role;
    /**
     * URL to the endpoint.
     */
    @JsonProperty("url")
    private String url;

    public void setIdentifier(ModuleID identifier) {
        requiredValidator.validate(identifier);
        this.identifier = identifier;
    }

    public void setRole(InterfaceRole role) {
        requiredValidator.validate(role);
        this.role = role;
    }

    public void setUrl(String url) {
        urlValidator.validate(url);
        this.url = url;
    }

    @Override
    public boolean validate() {
        return urlValidator.safeValidate(url)
                && requiredValidator.safeValidate(role)
                && requiredValidator.safeValidate(identifier);
    }
}
