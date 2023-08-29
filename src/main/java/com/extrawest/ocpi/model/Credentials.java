package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.vo.CredentialsRole;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
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
public class Credentials implements Validatable {

    @JsonIgnore
    private final Validator urlValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();
    @JsonIgnore
    private final Validator tokenValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string64())
                    .build();
    @JsonIgnore
    private final Validator rolesValidator = new ListOfAtLeastOneObjects();

    /**
     * Case Sensitive, ASCII only. The credentials token for the other party to authenticate in your system.
     * Not encoded in Base64 or any other encoding.
     */
    @JsonProperty("token")
    private String token;
    /**
     * The URL to your API versions endpoint.
     */
    @JsonProperty("url")
    private String url;
    /**
     * List of the roles this party provides.
     */
    @JsonProperty("roles")
    private List<CredentialsRole> roles;

    public void setToken(String token) {
        tokenValidator.validate(token);
        this.token = token;
    }

    public void setUrl(String url) {
        urlValidator.validate(url);
        this.url = url;
    }

    public void setRoles(List<CredentialsRole> roles) {
        rolesValidator.validate(roles);
        this.roles = roles;
    }

    @Override
    public boolean validate() {
        return tokenValidator.safeValidate(token)
                && urlValidator.safeValidate(url)
                && rolesValidator.safeValidate(roles)
                && roles.stream().filter(CredentialsRole::validate).count() == roles.size();
    }
}
