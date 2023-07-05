package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.enums.ChargingProfileResponseType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargingProfileResponseDTO {
    @NotBlank
    private ChargingProfileResponseType result;
    @NotBlank
    private Integer timeout;
}
