package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.dto.SessionDTO;
import com.extrawest.ocpi.model.dto.ChargingPreferencesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cpo/api/2.2.1/sessions")
public abstract class CPOSessionsController {

    /**
     * Fetch Session objects of charging sessions last updated between the {date_from} and {date_to} (paginated).
     * @param dateFrom Only return Sessions that have last_updated after or equal to this Date/Time (inclusive).
     * @param dateTo Only return Sessions that have last_updated up to this Date/Time, but not including (exclusive).
     * @param offset The offset of the first object returned. Default is 0.
     * @param limit Maximum number of objects to GET
     * @return List of Session objects that match the request parameters.
     */
    @GetMapping
    public abstract ResponseEntity<List<SessionDTO>> getSessions(
            @RequestParam(value = "date_from") LocalDateTime dateFrom,
            @RequestParam(value = "date_to", required = false) LocalDateTime dateTo,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false) Integer limit
    );

    /**
     * Setting Charging Preferences of an ongoing session.
     * @param sessionId Setting Charging Preferences of an ongoing session.
     * @param chargingPreferencesDTO Updated Charging Preferences of the driver for this Session.
     * @return Response to the Charging Preferences PUT request.
     */
    @PutMapping
    public abstract ResponseEntity<ChargingPreferencesDTO> putChargingPreferences(
            @RequestParam(value = "session_id") String sessionId,
            @RequestBody ChargingPreferencesDTO chargingPreferencesDTO
    );

}
