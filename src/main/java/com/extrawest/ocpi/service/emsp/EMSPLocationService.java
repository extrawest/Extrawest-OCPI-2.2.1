package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.AbstractDomainObject;
import com.extrawest.ocpi.model.dto.LocationDTO;

public interface EMSPLocationService {

    AbstractDomainObject getLocationEvseController(
            String countryCode, String party_id, String locationId, String evseUid, String connectorId
    );
    void pushLocation(
            LocationDTO locationDTO, String countryCode, String party_id, String locationId, String evseUid, String connectorId
    );
    void patchLocation(
            LocationDTO locationDTO, String countryCode, String party_id, String locationId, String evseUid, String connectorId
    );

}
