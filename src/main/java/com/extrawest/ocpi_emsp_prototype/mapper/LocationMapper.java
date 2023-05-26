package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.dto.request.LocationRequestDTO;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.LocationResponseDTO;
import com.extrawest.ocpi_emsp_prototype.model.Location;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location toLocationEntity(LocationRequestDTO locationRequestDTO);
    LocationResponseDTO toTariffResponseDTO(Location location);
    List<LocationResponseDTO> toListTariffResponseDTO(List<Location> locations);
    List<Location> toListLocation(List<LocationRequestDTO> locations);
}
