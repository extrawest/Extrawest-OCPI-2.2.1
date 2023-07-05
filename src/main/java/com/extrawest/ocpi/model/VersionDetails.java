package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.VersionNumber;
import com.extrawest.ocpi.model.vo.Endpoint;
import com.extrawest.ocpi.validation.ListOfAtLeastOneObjects;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class VersionDetails implements Validatable {

    @JsonIgnore
    private final Validator endpointsValidator = new ListOfAtLeastOneObjects();
    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * The version number.
     */
    @JsonProperty("version")
    private VersionNumber version;
    /**
     * A list of supported endpoints for this version.
     */
    @JsonProperty("endpoints")
    private List<Endpoint> endpoints;

    public void setVersion(VersionNumber version) {
        requiredValidator.validate(version);
        this.version = version;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        endpointsValidator.validate(endpoints);
        this.endpoints = endpoints;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(version)
                && endpointsValidator.safeValidate(endpoints)
                && endpoints.stream().filter(Endpoint::validate).count() == endpoints.size();
    }
}
