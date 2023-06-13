package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.enums.ChargingProfileResponseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargingProfileResponseDTO {
    private ChargingProfileResponseType result;
    private Integer timeout;
}
