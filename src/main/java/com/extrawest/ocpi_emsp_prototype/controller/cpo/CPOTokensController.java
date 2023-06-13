package com.extrawest.ocpi_emsp_prototype.controller.cpo;

import com.extrawest.ocpi_emsp_prototype.model.dto.TokenDTO;
import com.extrawest.ocpi_emsp_prototype.model.enums.TokenType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpo/api/2.2.1/tokens")
public abstract class CPOTokensController {

    /**
     * Retrieve a Token as it is stored in the CPO system.
     * @param countryCode Country code of the eMSP requesting this GET from the CPO system.
     * @param partyId Country code of the eMSP requesting this GET from the CPO system.
     * @param tokenUid Token.uid of the Token object to retrieve.
     * @param type Token.type of the Token to retrieve. Default if omitted: RFID
     * @return The requested Token object.
     */
    @GetMapping("/{country_code}/{party_id}/{token_uid}/{type}")
    public abstract ResponseEntity<TokenDTO> getToken(
            @PathVariable(value = "country_code") String countryCode,
            @PathVariable(value = "party_id") String partyId,
            @PathVariable(value = "token_uid") String tokenUid,
            @PathVariable(value = "type", required = false) TokenType type
    );

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
    public abstract void putToken(
            @RequestBody TokenDTO tokenDTO,
            @PathVariable(value = "country_code") String countryCode,
            @PathVariable(value = "party_id") String partyId,
            @PathVariable(value = "token_uid") String tokenUid,
            @PathVariable(value = "type", required = false) TokenType type
    );

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
    public abstract void patchToken(
            @RequestBody TokenDTO tokenDTO,
            @PathVariable(value = "country_code") String countryCode,
            @PathVariable(value = "party_id") String partyId,
            @PathVariable(value = "token_uid") String tokenUid,
            @PathVariable(value = "type", required = false) TokenType type
    );

}
