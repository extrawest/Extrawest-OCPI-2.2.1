package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.Location;
import com.extrawest.ocpi.model.dto.LocationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location toLocationEntity(LocationDTO locationDTO);
    LocationDTO toLocationDTO(Location location);
    List<LocationDTO> toListLocationDTO(List<Location> locations);
    List<Location> toListLocation(List<LocationDTO> locations);
}
