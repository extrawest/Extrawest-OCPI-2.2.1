package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.ConnectionStatus;
import com.extrawest.ocpi.model.enums.Role;
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
public class ClientInfoDTO {
    @NotBlank
    @Size(min = 1, max = 3)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("party_id")
    private String partyId;
    @NotBlank
    @Size(min = 1, max = 2)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("country_code")
    private String countryCode;
    @NotBlank
    @JsonProperty("role")
    private Role role;
    @NotBlank
    @JsonProperty("status")
    private ConnectionStatus status;
    @NotBlank
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
