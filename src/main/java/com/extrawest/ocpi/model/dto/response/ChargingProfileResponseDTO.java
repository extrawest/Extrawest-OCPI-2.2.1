package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.enums.ChargingProfileResponseType;
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
