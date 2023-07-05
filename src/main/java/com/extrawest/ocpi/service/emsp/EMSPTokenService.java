package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.dto.TokenDTO;
import com.extrawest.ocpi.model.dto.request.LocationReferencesRequestDTO;
import com.extrawest.ocpi.model.dto.response.AuthorizationInfoResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface EMSPTokenService {

    List<TokenDTO> getToken(LocalDateTime dateFrom, LocalDateTime dateTo, Integer offset, Integer limit);
    AuthorizationInfoResponseDTO postToken(String tokenUid,
                                           String type,
                                           LocationReferencesRequestDTO locationReferencesRequestDTO
    );

}
