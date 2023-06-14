package com.extrawest.ocpi_emsp_prototype.controller;

import com.extrawest.ocpi_emsp_prototype.model.dto.ClientInfoDTO;
import jakarta.validation.constraints.Max;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/2.2.1/hubClientInfo")
public abstract class ClientInfoController {

    /**
     * Retrieve a ClientInfo object as it is stored in the connected clients system.
     * @param countryCode Country code of the requested ClientInfo object.
     * @param partyId Party ID (Provider ID) of the requested ClientInfo object.
     * @return The requested ClientInfo object.
     */
    @GetMapping("/{country_code}/{party_id}")
    public abstract ResponseEntity<ClientInfoDTO> getHubClientInfo(
            @PathVariable(value = "country_code") @Max(2) String countryCode,
            @PathVariable(value = "party_id") @Max(3) String partyId
    );

    /**
     * Push new/updated ClientInfo object to the connect client.
     * @param countryCode Country code of the eMSP sending this PUT request to the CPO system.
     * @param partyId Party ID (Provider ID) of the eMSP sending this PUT request to the CPO system.
     */
    @PutMapping("/{country_code}/{party_id}")
    public abstract void putHubClientInfo(
            @PathVariable(value = "country_code") @Max(2) String countryCode,
            @PathVariable(value = "party_id") @Max(3) String partyId
    );

}
