package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.AbstractProfileResult;
import com.extrawest.ocpi.model.ResponseFormat;
import com.extrawest.ocpi.model.dto.request.ActiveChargingProfileRequestDTO;

public interface EMSPChargingProfilesService {

    ResponseFormat postChargingProfile(AbstractProfileResult abstractProfileResult);
    ResponseFormat putChargingProfile(String sessionId, ActiveChargingProfileRequestDTO activeChargingProfile);

}
