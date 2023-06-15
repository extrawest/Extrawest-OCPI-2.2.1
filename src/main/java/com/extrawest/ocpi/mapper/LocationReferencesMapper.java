package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.vo.LocationReferences;
import com.extrawest.ocpi.model.dto.request.LocationReferencesRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationReferencesMapper {
    LocationReferencesRequestDTO toLocationReferencesRequestDTO (LocationReferences locationReferences);
    LocationReferences toLocationReferencesEntity (LocationReferencesRequestDTO locationReferencesRequestDTO);
}
