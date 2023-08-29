package com.extrawest.ocpi.service;

import com.extrawest.ocpi.model.dto.ClientInfoDTO;

public interface ClientInfoService {

    ClientInfoDTO getHubClientInfo(String countryCode, String partyId);
    void putHubClientInfo(String countryCode, String partyId);

}
