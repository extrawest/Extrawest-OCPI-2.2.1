package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.AbstractDomainObject;
import com.extrawest.ocpi.model.dto.LocationDTO;
import com.extrawest.ocpi.service.cpo.CPOLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cpo/api/2.2.1/locations")
public class CPOLocationController {

    protected final CPOLocationService cpoLocationService;

    protected CPOLocationController(@Autowired CPOLocationService cpoLocationService) {
        this.cpoLocationService = cpoLocationService;
    }

    /**
     * Fetch a list of Locations, last updated between the {date_from} and {date_to} (paginated)
     * @param dateFrom Only return Locations that have last_updated after or equal to this Date/Time (inclusive).
     * @param dateTo Only return Locations that have last_updated after or equal to this Date/Time (inclusive).
     * @param offset The offset of the first object returned. Default is 0.
     * @param limit Maximum number of objects to GET.
     * @return List of all Locations with valid EVSEs.
     */
    @GetMapping("/getLocations")
    public ResponseEntity<List<LocationDTO>> getLocations(
            @RequestParam(value = "date_from", required = false) LocalDateTime dateFrom,
            @RequestParam(value = "date_to", required = false) LocalDateTime dateTo,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false) Integer limit
    ) {
        return ResponseEntity.ok(cpoLocationService.getLocations(dateFrom, dateTo, offset, limit));
    };

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
    @GetMapping
    public ResponseEntity<AbstractDomainObject> getLocationEvseController(
            @RequestParam(value = "location_id") String locationId,
            @RequestParam(value = "evse_uid", required = false) String evseUid,
            @RequestParam(value = "connector_id", required = false) String connectorId
    ) {
        return ResponseEntity.ok(cpoLocationService.getLocationEvseController(locationId, evseUid, connectorId));
    };
}
