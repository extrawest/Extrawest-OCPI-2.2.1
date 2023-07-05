package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.dto.TokenDTO;
import com.extrawest.ocpi.model.enums.TokenType;

public interface CPOTokensService {

    TokenDTO getToken(String countryCode, String partyId,String tokenUid, TokenType type);
    void putToken(TokenDTO tokenDTO, String countryCode, String partyId, String tokenUid, TokenType type);
    void patchToken(TokenDTO tokenDTO, String countryCode, String partyId, String tokenUid, TokenType type);

}
