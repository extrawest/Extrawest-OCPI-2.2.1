package com.extrawest.ocpi_emsp_prototype.model.dto;

import com.extrawest.ocpi_emsp_prototype.model.enums.ProfileType;
import com.extrawest.ocpi_emsp_prototype.model.enums.TokenType;
import com.extrawest.ocpi_emsp_prototype.model.enums.WhitelistType;
import com.extrawest.ocpi_emsp_prototype.model.vo.EnergyContract;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("party_id")
    private String partyId;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("type")
    private TokenType type;
    @JsonProperty("contract_id")
    private String contractId;
    @JsonProperty("visual_number")
    private String visualNumber;
    @JsonProperty("issuer")
    private String issuer;
    @JsonProperty("group_id")
    private String groupId;
    @JsonProperty("valid")
    private Boolean valid;
    @JsonProperty("whitelist")
    private WhitelistType whitelist;
    @JsonProperty("language")
    private String language;
    @JsonProperty("default_profile_type")
    private ProfileType defaultProfileType;
    @JsonProperty("energy_contract")
    private EnergyContract energyContract;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
