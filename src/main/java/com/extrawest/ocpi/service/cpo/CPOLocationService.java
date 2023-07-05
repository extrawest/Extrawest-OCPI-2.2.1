package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.AbstractDomainObject;
import com.extrawest.ocpi.model.dto.LocationDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CPOLocationService {

    List<LocationDTO> getLocations(LocalDateTime dateFrom, LocalDateTime dateTo, Integer offset, Integer limit);
    AbstractDomainObject getLocationEvseController (String locationId, String evseUid, String connectorId);

}
