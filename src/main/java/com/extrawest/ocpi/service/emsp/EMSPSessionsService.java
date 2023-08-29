package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.dto.SessionDTO;

public interface EMSPSessionsService {

    SessionDTO getSession(String countryCode, String partyId, String sessionId);
    void putSession(SessionDTO sessionDTO, String countryCode, String partyId, String sessionId);
    void patchSession(SessionDTO sessionDTO, String countryCode, String partyId, String sessionId);

}
