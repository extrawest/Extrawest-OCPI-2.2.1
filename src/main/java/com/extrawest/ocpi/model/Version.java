package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.VersionNumber;
import com.extrawest.ocpi.validation.*;
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
public class Version implements Validatable {

    @JsonIgnore
    private final Validator urlValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();
    @JsonIgnore
    private final Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * The version number.
     */
    @JsonProperty("version")
    private VersionNumber version;
    /**
     * URL to the endpoint containing version specific information.
     */
    @JsonProperty("url")
    private String url;

    public void setVersion(VersionNumber version) {
        requiredValidator.validate(version);
        this.version = version;
    }

    public void setUrl(String url) {
        urlValidator.validate(url);
        this.url = url;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(version)
                && urlValidator.safeValidate(url);
    }
}
