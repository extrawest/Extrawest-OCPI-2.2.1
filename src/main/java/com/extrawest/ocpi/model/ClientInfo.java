package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.ConnectionStatus;
import com.extrawest.ocpi.model.enums.Role;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ClientInfo implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * CPO or eMSP ID of this party (following the 15118 ISO standard), as used in the credentials exchange.
     */
    @JsonProperty("party_id")
    private String partyId;

    /**
     * Country code of the country this party is operating in, as used in the credentials exchange.
     */
    @JsonProperty("country_code")
    private String countryCode;

    /**
     * The role of the connected party
     */
    @JsonProperty("role")
    private Role role;

    /**
     * Status of the connection to the party.
     */
    @JsonProperty("status")
    private ConnectionStatus status;

    /**
     * Timestamp when this ClientInfo object was last updated.
     */
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;

    public void setPartyId(String partyId) {
        requiredValidator.validate(partyId);
        this.partyId = partyId;
    }

    public void setCountryCode(String countryCode) {
        requiredValidator.validate(countryCode);
        this.countryCode = countryCode;
    }

    public void setRole(Role role) {
        requiredValidator.validate(role);
        this.role = role;
    }

    public void setStatus(ConnectionStatus status) {
        requiredValidator.validate(status);
        this.status = status;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        requiredValidator.validate(lastUpdated);
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(partyId)
                && requiredValidator.safeValidate(countryCode)
                && requiredValidator.safeValidate(role)
                && requiredValidator.safeValidate(status)
                && requiredValidator.safeValidate(lastUpdated);
    }
}
