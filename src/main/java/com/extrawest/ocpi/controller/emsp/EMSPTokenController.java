package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.TokenDTO;
import com.extrawest.ocpi.model.dto.request.LocationReferencesRequestDTO;
import com.extrawest.ocpi.model.dto.response.AuthorizationInfoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/emsp/api/2.2.1/tokens")
public abstract class EMSPTokenController {

    /**
     * Get the list of known Tokens, last updated between the {date_from} and {date_to} (paginated)
     * @param dateFrom Only return Tokens that have last_updated after or equal to this Date/Time (inclusive).
     * @param dateTo Only return Tokens that have last_updated up to this Date/Time, but not including (exclusive).
     * @param offset The offset of the first object returned. Default is 0.
     * @param limit Maximum number of objects to GET
     * @return List of all tokens.
     */
    @GetMapping("/{date_from}/{date_to}/{offset}/{limit}")
    public abstract ResponseEntity<List<TokenDTO>> getToken(
            @PathVariable (value = "date_from", required = false) LocalDateTime dateFrom,
            @PathVariable (value = "date_to", required = false) LocalDateTime dateTo,
            @PathVariable (value = "offset", required = false) Integer offset,
            @PathVariable (value = "limit", required = false) Integer limit
    );

    /**
     * Real-time authorization request
     * @param tokenUid Token.uid of the Token for which authorization is requested.
     * @param type Token.type of the Token for which this authorization is. Default if omitted: RFID
     * @param locationReferencesRequestDTO Location and EVSEs for which the Token is requested to be authorized.
     * @return Contains information about the authorization, if the Token is allowed to charge and optionally
     * which EVSEs are allowed to be used.
     */
    @PostMapping("/{token_uid}/{type}")
    public abstract ResponseEntity<AuthorizationInfoResponseDTO> postToken(
            @PathVariable(value = "token_uid") String tokenUid,
            @PathVariable(value = "type", required = false) String type,
            @RequestBody LocationReferencesRequestDTO locationReferencesRequestDTO
            );

}
