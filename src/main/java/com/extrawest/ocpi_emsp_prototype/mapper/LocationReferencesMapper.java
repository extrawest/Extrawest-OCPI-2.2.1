package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.dto.request.LocationReferencesRequestDTO;
import com.extrawest.ocpi_emsp_prototype.model.vo.LocationReferences;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationReferencesMapper {
    LocationReferencesRequestDTO toLocationReferencesRequestDTO (LocationReferences locationReferences);
    LocationReferences toLocationReferencesEntity (LocationReferencesRequestDTO locationReferencesRequestDTO);
}
