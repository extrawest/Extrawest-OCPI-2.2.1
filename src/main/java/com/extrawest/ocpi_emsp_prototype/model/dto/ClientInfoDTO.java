package com.extrawest.ocpi_emsp_prototype.model.dto;

import com.extrawest.ocpi_emsp_prototype.model.enums.ConnectionStatus;
import com.extrawest.ocpi_emsp_prototype.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDTO {
    @JsonProperty("party_id")
    private String partyId;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("role")
    private Role role;
    @JsonProperty("status")
    private ConnectionStatus status;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
