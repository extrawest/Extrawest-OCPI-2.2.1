package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.dto.TokenDTO;
import com.extrawest.ocpi.model.enums.TokenType;
import com.extrawest.ocpi.service.cpo.CPOTokensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cpo/api/2.2.1/tokens")
public class CPOTokensController {

    protected final CPOTokensService cpoTokensService;

    protected CPOTokensController(@Autowired CPOTokensService cpoTokensService) {
        this.cpoTokensService = cpoTokensService;
    }

    /**
     * Retrieve a Token as it is stored in the CPO system.
     * @param countryCode Country code of the eMSP requesting this GET from the CPO system.
     * @param partyId Country code of the eMSP requesting this GET from the CPO system.
     * @param tokenUid Token.uid of the Token object to retrieve.
     * @param type Token.type of the Token to retrieve. Default if omitted: RFID
     * @return The requested Token object.
     */
    @GetMapping("/{country_code}/{party_id}/{token_uid}/{type}")
    public ResponseEntity<TokenDTO> getToken(
            @PathVariable(value = "country_code") String countryCode,
            @PathVariable(value = "party_id") String partyId,
            @PathVariable(value = "token_uid") String tokenUid,
            @PathVariable(value = "type", required = false) TokenType type
    ) {
        return ResponseEntity.ok(cpoTokensService.getToken(countryCode, partyId, tokenUid, type));
    };

    /**
     * Push new/updated Token object to the CPO.
     * @param tokenDTO New or updated Token object.
     * @param countryCode Country code of the eMSP sending this PUT request to the CPO system. This SHALL be the same value
     * as the country_code in the Token object being pushed.
     * @param partyId Party ID (Provider ID) of the eMSP sending this PUT request to the CPO system.
     * This SHALL be the same value as the party_id in the Token object being pushed.
     * @param tokenUid Token.uid of the (new) Token object (to replace).
     * @param type Token.type of the Token of the (new) Token object (to replace). Default if omitted: RFID
     */
    @PutMapping("/{country_code}/{party_id}/{token_uid}/{type}")
    public void putToken(
            @RequestBody @Valid TokenDTO tokenDTO,
            @PathVariable(value = "country_code") String countryCode,
            @PathVariable(value = "party_id") String partyId,
            @PathVariable(value = "token_uid") String tokenUid,
            @PathVariable(value = "type", required = false) TokenType type
    ) {
        cpoTokensService.putToken(tokenDTO, countryCode, partyId, tokenUid, type);
    };

    /**
     * Notify the CPO of partial updates to a Token.
     * @param tokenDTO New or updated Token object.
     * @param countryCode Country code of the eMSP sending this PUT request to the CPO system. This SHALL be the same value
     * as the country_code in the Token object being pushed.
     * @param partyId Party ID (Provider ID) of the eMSP sending this PUT request to the CPO system.
     * This SHALL be the same value as the party_id in the Token object being pushed.
     * @param tokenUid Token.uid of the (new) Token object (to replace).
     * @param type Token.type of the Token of the (new) Token object (to replace). Default if omitted: RFID
     */
    @PatchMapping("/{country_code}/{party_id}/{token_uid}/{type}")
    public void patchToken(
            @RequestBody @Valid TokenDTO tokenDTO,
            @PathVariable(value = "country_code") String countryCode,
            @PathVariable(value = "party_id") String partyId,
            @PathVariable(value = "token_uid") String tokenUid,
            @PathVariable(value = "type", required = false) TokenType type
    ) {
        cpoTokensService.patchToken(tokenDTO, countryCode, partyId, tokenUid, type);
    };

}
