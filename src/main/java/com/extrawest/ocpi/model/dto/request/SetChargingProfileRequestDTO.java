package com.extrawest.ocpi.model.dto.request;

import com.extrawest.ocpi.model.vo.ChargingProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetChargingProfileRequestDTO {
    @NotBlank
    @JsonProperty("charging_profile")
    private ChargingProfile chargingProfile;
    @NotBlank
    @JsonProperty("response_url ")
    private String responseUrl;
}
