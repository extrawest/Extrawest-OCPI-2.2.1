package com.extrawest.ocpi_emsp_prototype.controller.emsp;

import com.extrawest.ocpi_emsp_prototype.model.AbstractDomainObject;
import com.extrawest.ocpi_emsp_prototype.model.dto.LocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emsp/api/2.2.1/locations")
public abstract class EMSPLocationController {

    /**
     * Retrieve a Location as it is stored in the eMSP system.
     * @param countryCode Country code of the CPO requesting data from the eMSP system.
     * @param party_id Party ID (Provider ID) of the CPO requesting data from the eMSP system.
     * @param locationId Location.id of the Location object to retrieve.
     * @param evseUid Evse.uid, required when requesting an EVSE or Connector object.
     * @param connectorId Evse.uid, required when requesting an EVSE or Connector object.
     * @return The response contains the requested object:
     *      Location - If a Location object was requested: the Location object.
     *      EVSE - If an EVSE object was requested: the EVSE object.
     *      Connector - If a Connector object was requested: the Connector object.
     */
    @GetMapping
    public abstract ResponseEntity<AbstractDomainObject> getLocationEvseController(
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String party_id,
            @RequestParam(value = "location_id") String locationId,
            @RequestParam(value = "evse_uid", required = false) String evseUid,
            @RequestParam(value = "connector_id", required = false) String connectorId
    );

    /**
     * The CPO pushes available Location, EVSE or Connector objects to the eMSP. PUT can be used to send
     * new Location objects to the eMSP but also to replace existing Locations.
     * @param locationDTO The request body contains the new/updated object.
     * @param countryCode Country code of the CPO requesting this PUT to the eMSP system.
     *                    This SHALL be the same value as the country_code in the Location object being pushed.
     * @param party_id Party ID (Provider ID) of the CPO requesting this PUT to the eMSP system.
     *                 This SHALL be the same value as the party_id in the Location object being pushed.
     * @param locationId Location.id of the new Location object, or the Location of which an EVSE or
     *                   Connector object is pushed.
     * @param evseUid Evse.uid, required when an EVSE or Connector object is pushed.
     * @param connectorId Connector.id, required when a Connector object is pushed.
     */
    @PutMapping
    public abstract void pushLocation(
            @RequestBody LocationDTO locationDTO,
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String party_id,
            @RequestParam(value = "location_id") String locationId,
            @RequestParam(value = "evse_uid", required = false) String evseUid,
            @RequestParam(value = "connector_id", required = false) String connectorId
    );

    /**
     * The CPO pushes available Location, EVSE or Connector objects to the eMSP. PUT can be used to send
     * new Location objects to the eMSP but also to replace existing Locations.
     * @param locationDTO The request body contains the new/updated object.
     * @param countryCode Country code of the CPO requesting this PUT to the eMSP system.
     *                    This SHALL be the same value as the country_code in the Location object being pushed.
     * @param party_id Party ID (Provider ID) of the CPO requesting this PUT to the eMSP system.
     *                 This SHALL be the same value as the party_id in the Location object being pushed.
     * @param locationId Location.id of the new Location object, or the Location of which an EVSE or
     *                   Connector object is pushed.
     * @param evseUid Evse.uid, required when an EVSE or Connector object is pushed.
     * @param connectorId Connector.id, required when a Connector object is pushed.
     */
    @PatchMapping
    public abstract void  patchLocation(
            @RequestBody LocationDTO locationDTO,
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String party_id,
            @RequestParam(value = "location_id") String locationId,
            @RequestParam(value = "evse_uid", required = false) String evseUid,
            @RequestParam(value = "connector_id", required = false) String connectorId
    );

}
