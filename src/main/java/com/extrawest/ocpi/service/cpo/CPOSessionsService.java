package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.dto.ChargingPreferencesDTO;
import com.extrawest.ocpi.model.dto.SessionDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CPOSessionsService {

    List<SessionDTO> getSessions(LocalDateTime dateFrom, LocalDateTime dateTo, Integer offset, Integer limit);
    ChargingPreferencesDTO putChargingPreferences(String sessionId, ChargingPreferencesDTO chargingPreferencesDTO);

}
