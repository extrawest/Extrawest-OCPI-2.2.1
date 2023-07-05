package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.ProfileType;
import com.extrawest.ocpi.model.enums.TokenType;
import com.extrawest.ocpi.model.enums.WhitelistType;
import com.extrawest.ocpi.model.vo.EnergyContract;
import com.extrawest.ocpi.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
    @NotBlank
    @Size(min = 1, max = 2)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("country_code")
    private String countryCode;
    @NotBlank
    @Size(min = 1, max = 3)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("party_id")
    private String partyId;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("uid")
    private String uid;
    @NotBlank
    @JsonProperty("type")
    private TokenType type;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("contract_id")
    private String contractId;
    @Size(min = 1, max = 64)
    @JsonProperty("visual_number")
    private String visualNumber;
    @NotBlank
    @Size(min = 1, max = 64)
    @JsonProperty("issuer")
    private String issuer;
    @Size(min = 1, max = 36)
    @JsonProperty("group_id")
    private String groupId;
    @NotBlank
    @JsonProperty("valid")
    private Boolean valid;
    @NotBlank
    @JsonProperty("whitelist")
    private WhitelistType whitelist;
    @Size(min = 1, max = 2)
    @JsonProperty("language")
    private String language;
    @JsonProperty("default_profile_type")
    private ProfileType defaultProfileType;
    @JsonProperty("energy_contract")
    private EnergyContract energyContract;
    @NotBlank
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
