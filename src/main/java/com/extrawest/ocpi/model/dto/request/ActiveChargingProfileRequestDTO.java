package com.extrawest.ocpi.model.dto.request;

import com.extrawest.ocpi.model.vo.ChargingProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveChargingProfileRequestDTO {
    @NotBlank
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    @NotBlank
    @JsonProperty("charging_profile")
    private ChargingProfile chargingProfile;
}
