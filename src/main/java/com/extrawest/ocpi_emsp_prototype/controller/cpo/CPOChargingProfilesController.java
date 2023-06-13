package com.extrawest.ocpi_emsp_prototype.controller.cpo;

import com.extrawest.ocpi_emsp_prototype.model.dto.request.SetChargingProfileRequestDTO;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.ChargingProfileResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpo/api/2.2.1/chargingProfiles")
public abstract class CPOChargingProfilesController {

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
    public abstract ResponseEntity<ChargingProfileResponseDTO> getChargingProfile(
            @PathVariable(value = "session_id") String sessionId,
            @PathVariable(value = "duration") Integer duration,
            @PathVariable(value = "response_url") String responseUrl
    );

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
    public abstract ResponseEntity<ChargingProfileResponseDTO> putChargingProfile(
            @PathVariable(value = "session_id") String sessionId,
            @RequestBody SetChargingProfileRequestDTO setChargingProfileRequestDTO
    );

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
    public abstract ResponseEntity<ChargingProfileResponseDTO> deleteChargingProfile(
            @PathVariable(value = "session_id") String sessionId,
            @PathVariable(value = "response_url") String responseUrl
    );

}
