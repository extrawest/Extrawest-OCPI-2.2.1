package com.extrawest.ocpi_emsp_prototype.model.dto.request;

import com.extrawest.ocpi_emsp_prototype.model.vo.ChargingProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetChargingProfileRequestDTO {
    @JsonProperty("charging_profile")
    private ChargingProfile chargingProfile;
    @JsonProperty("response_url ")
    private String responseUrl;
}
