package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.dto.request.SetChargingProfileRequestDTO;
import com.extrawest.ocpi.model.dto.response.ChargingProfileResponseDTO;

public interface CPOChargingProfilesService {

    ChargingProfileResponseDTO getChargingProfile(String sessionId, Integer duration, String responseUrl);
    ChargingProfileResponseDTO putChargingProfile(String sessionId, SetChargingProfileRequestDTO setChargingProfileRequestDTO);
    ChargingProfileResponseDTO deleteChargingProfile(String sessionId, String responseUrl);

}
