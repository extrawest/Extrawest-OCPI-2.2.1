package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.Location;
import com.extrawest.ocpi_emsp_prototype.model.dto.LocationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location toLocationEntity(LocationDTO locationDTO);
    LocationDTO toLocationDTO(Location location);
    List<LocationDTO> toListLocationDTO(List<Location> locations);
    List<Location> toListLocation(List<LocationDTO> locations);
}
