package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.dto.request.SetChargingProfileRequestDTO;
import com.extrawest.ocpi.model.dto.response.ChargingProfileResponseDTO;
import com.extrawest.ocpi.service.cpo.CPOChargingProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cpo/api/2.2.1/chargingProfiles")
public class CPOChargingProfilesController {

    protected final CPOChargingProfilesService cpoChargingProfilesService;

    protected CPOChargingProfilesController(@Autowired CPOChargingProfilesService cpoChargingProfilesService) {
        this.cpoChargingProfilesService = cpoChargingProfilesService;
    }

    /**
     * Gets the ActiveChargingProfile for a specific charging session.
     * @param sessionId The unique id that identifies the session in the CPO platform.
     * @param duration Length of the requested ActiveChargingProfile in seconds Duration in seconds. *
     * @param responseUrl URL that the ActiveChargingProfileResult POST should be send to. This URL might contain
     * an unique ID to be able to distinguish between GET ActiveChargingProfile requests.
     * @return Result of the ActiveChargingProfile request, by the Receiver (Typically CPO), not the location/EVSE.
     * So this indicates if the Receiver understood the ChargingProfile request and was able to send it to the EVSE.
     * This is not the response by the Charge Point.
     */
    @GetMapping("/{session_id}/{duration}/{response_url}")
    public ResponseEntity<ChargingProfileResponseDTO> getChargingProfile(
            @PathVariable(value = "session_id") String sessionId,
            @PathVariable(value = "duration") Integer duration,
            @PathVariable(value = "response_url") String responseUrl
    ) {
        return ResponseEntity.ok(cpoChargingProfilesService.getChargingProfile(sessionId, duration, responseUrl));
    };

    /**
     * Creates/updates a ChargingProfile for a specific charging session.
     * @param sessionId The unique id that identifies the session in the CPO platform.
     * @param setChargingProfileRequestDTO SetChargingProfile object with information needed to set/update
     * the Charging Profile for a session.
     * @return Result of the ChargingProfile PUT request, by the CPO (not the location/EVSE). So this indicates if
     * the CPO understood the ChargingProfile PUT request and was able to send it to the EVSE.
     * This is not the response by the Charge Point.
     */
    @PutMapping("/{session_id}")
    public ResponseEntity<ChargingProfileResponseDTO> putChargingProfile(
            @PathVariable(value = "session_id") String sessionId,
            @RequestBody @Valid SetChargingProfileRequestDTO setChargingProfileRequestDTO
    ) {
        return ResponseEntity.ok(cpoChargingProfilesService.putChargingProfile(sessionId, setChargingProfileRequestDTO));
    };

    /**
     * Cancels an existing ChargingProfile for a specific charging session.
     * @param sessionId The unique id that identifies the session in the CPO platform.
     * @param responseUrl URL that the ClearProfileResult POST should be send to. This URL might contain an
     * unique ID to be able to distinguish between DELETE ChargingProfile requests.
     * @return Result of the ChargingProfile DELETE request, by the CPO (not the location/EVSE). So this indicates
     * if the CPO understood the ChargingProfile DELETE request and was able to send it to the EVSE. This is
     * not the response by the Charge Point.
     */
    @DeleteMapping("/{session_id}/{response_url}")
    public ResponseEntity<ChargingProfileResponseDTO> deleteChargingProfile(
            @PathVariable(value = "session_id") String sessionId,
            @PathVariable(value = "response_url") String responseUrl
    ) {
        return ResponseEntity.ok(cpoChargingProfilesService.deleteChargingProfile(sessionId, responseUrl));
    };

}
