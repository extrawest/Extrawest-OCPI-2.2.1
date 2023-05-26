package com.extrawest.ocpi_emsp_prototype.controller.cpo;

import com.extrawest.ocpi_emsp_prototype.model.LocationEvseConnector;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.LocationResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cpo/api/locations")
public abstract class CPOLocationController {

    /**
     * Fetch a list of Locations, last updated between the {date_from} and {date_to} (paginated)
     * @param dateFrom Only return Locations that have last_updated after or equal to this Date/Time (inclusive).
     * @param dateTo Only return Locations that have last_updated after or equal to this Date/Time (inclusive).
     * @param offset The offset of the first object returned. Default is 0.
     * @param limit Maximum number of objects to GET.
     * @return List of all Locations with valid EVSEs.
     */
    @GetMapping("/getLocations")
    public abstract ResponseEntity<List<LocationResponseDTO>> getLocations(
            @RequestParam(value = "date_from", required = false) LocalDateTime dateFrom,
            @RequestParam(value = "date_to", required = false) LocalDateTime dateTo,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false) Integer limit
    );

    /**
     * Get a specific Location, EVSE or Connector.
     * @param locationId Location.id of the Location object to retrieve.
     * @param evseUid Evse.uid, required when requesting an EVSE or Connector object.
     * @param connectorId Connector.id, required when requesting a Connector object.
     * @return The response contains the requested object:
     *      Location - The response contains the requested object.
     *      EVSE - If an EVSE object was requested: the EVSE object.
     *      Connector - If a Connector object was requested: the Connector object.
     */
    @GetMapping("/getLocation")
    public abstract ResponseEntity<LocationEvseConnector> getLocationEvseController(
            @RequestParam(value = "location_id") String locationId,
            @RequestParam(value = "evse_uid", required = false) String evseUid,
            @RequestParam(value = "connector_id", required = false) String connectorId
    );
}