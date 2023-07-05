package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.AbstractProfileResult;
import com.extrawest.ocpi.model.ResponseFormat;
import com.extrawest.ocpi.model.dto.request.ActiveChargingProfileRequestDTO;
import com.extrawest.ocpi.service.emsp.EMSPChargingProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/emsp/api/2.2.1/chargingProfiles")
public class EMSPChargingProfilesController {

    protected final EMSPChargingProfilesService emspChargingProfilesService;

    protected EMSPChargingProfilesController(@Autowired EMSPChargingProfilesService emspChargingProfilesService) {
        this.emspChargingProfilesService = emspChargingProfilesService;
    }

    /**
     * Receive the asynchronous response from the Charge Point.
     * @param abstractProfileResult Choice: one of three
     * ActiveChargingProfileResult - Result of the GET ActiveChargingProfile request, from the Charge Point.
     * ChargingProfileResult Result of the PUT ChargingProfile request, from the Charge Point.
     * ClearProfileResult Result of the DELETE ChargingProfile request, from the Charge Point.
     * @return The response to the POST on the Sender interface SHALL contain the Response Format
     * with the data field omitted.
     */
    @PostMapping
    public ResponseEntity<ResponseFormat> postChargingProfile(
            @RequestBody AbstractProfileResult abstractProfileResult
    ) {
        return ResponseEntity.ok(emspChargingProfilesService.postChargingProfile(abstractProfileResult));
    };

    /**
     * Receiver (typically CPO) can send an updated ActiveChargingProfile when other inputs have made changes to
     * existing profile. When the Receiver (typically CPO) sends a update profile to the EVSE, for an other reason
     * then the Sender (Typically SCSP) asking, the Sender SHALL post an update to this interface. When a local
     * input influence the ActiveChargingProfile in the EVSE AND the Receiver (typically CPO) is made aware of this,
     * the Receiver SHALL post an update to this interface.
     * @param sessionId The unique id that identifies the session in the CPO platform.
     * @param activeChargingProfile The new ActiveChargingProfile. If there is no longer any charging profile active,
     * the ActiveChargingProfile SHALL reflect this by showing the maximum charging
     * capacity of the EVSE.
     * @return The response to the PUT on the eMSP interface SHALL contain the Response Format with the data field omitted.
     */
    @PutMapping("/{session_id}")
    public ResponseEntity<ResponseFormat> putChargingProfile(
            @PathVariable(value = "session_id") String sessionId,
            @RequestBody @Valid ActiveChargingProfileRequestDTO activeChargingProfile
    ) {
        return ResponseEntity.ok(emspChargingProfilesService.putChargingProfile(sessionId, activeChargingProfile));
    };

}
