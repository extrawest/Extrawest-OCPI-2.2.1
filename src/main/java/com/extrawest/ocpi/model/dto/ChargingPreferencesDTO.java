package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.ProfileType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargingPreferencesDTO {
    @NotBlank
    @JsonProperty("profile_type")
    private ProfileType profileType;
    @JsonProperty("departure_time")
    private LocalDateTime departureTime;
    @JsonProperty("energyNeed")
    private Float energyNeed;
    @JsonProperty("discharge_allowed")
    private Boolean dischargeAllowed = false;
}
