package com.extrawest.ocpi.model.vo;

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
public class BusinessDetails implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();
    @JsonIgnore
    private final Validator websiteValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string255())
                    .build();

    /**
     * Name of the operator.
     */
    @JsonProperty("name")
    private String name;
    /**
     * Link to the operator’s website.
     */
    @JsonProperty("website")
    private String website;
    /**
     * Image link to the operator’s logo.
     */
    @JsonProperty("logo")
    private Image logo;

    public void setName(String name) {
        requiredValidator.validate(name);
        this.name = name;
    }

    public void setWebsite(String website) {
        websiteValidator.validate(website);
        this.website = website;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(name);
    }
}
