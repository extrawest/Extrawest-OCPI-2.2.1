package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.SessionDTO;
import jakarta.validation.constraints.Max;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emsp/api/2.2.1/sessions")
public abstract class EMSPSessionsController {

    /**
     * Retrieve a Session object from the eMSP’s system with Session.id equal to {session_id}.
     * @param countryCode Retrieve a Session object from the eMSP’s system with Session.id equal to {session_id}.
     * @param partyId Party ID (Provider ID) of the CPO performing the GET on the eMSP’s system.
     * @param sessionId id of the Session object to get from the eMSP’s system.
     * @return Requested Session object.
     */
    @GetMapping
    public abstract ResponseEntity<SessionDTO> getSession(
            @RequestParam(value = "country_code") @Max(2) String countryCode,
            @RequestParam(value = "party_id") @Max(3) String partyId,
            @RequestParam(value = "session_id") @Max(36) String sessionId
    );

    /**
     * Send a new/updated Session object to the eMSP.
     * @param sessionDTO New or updated Session object.
     * @param countryCode Country code of the CPO performing this PUT on the eMSP’s system. This SHALL be the same
     * value as the country_code in the Session object being pushed.
     * @param partyId Party ID (Provider ID) of the CPO performing this PUT on the eMSP’s system. This SHALL be the
     * same value as the party_id in the Session object being pushed.
     * @param sessionId id of the new or updated Session object.
     */
    @PutMapping
    public abstract void putSession(
            @RequestBody SessionDTO sessionDTO,
            @RequestParam(value = "country_code") @Max(2) String countryCode,
            @RequestParam(value = "party_id") @Max(3) String partyId,
            @RequestParam(value = "session_id") @Max(36) String sessionId
    );

    /**
     * Send a new/updated Session object to the eMSP.
     * @param sessionDTO New or updated Session object.
     * @param countryCode Country code of the CPO performing this PUT on the eMSP’s system. This SHALL be the same
     * value as the country_code in the Session object being pushed.
     * @param partyId Party ID (Provider ID) of the CPO performing this PUT on the eMSP’s system. This SHALL be the
     * same value as the party_id in the Session object being pushed.
     * @param sessionId id of the new or updated Session object.
     */
    @PatchMapping
    public abstract void patchSession(
            @RequestBody SessionDTO sessionDTO,
            @RequestParam(value = "country_code") @Max(2) String countryCode,
            @RequestParam(value = "party_id") @Max(3) String partyId,
            @RequestParam(value = "session_id") @Max(36) String sessionId
    );

}
