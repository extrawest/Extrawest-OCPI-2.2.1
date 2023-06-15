package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.Version;
import com.extrawest.ocpi.model.dto.response.VersionResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VersionMapper {
    VersionResponseDTO toVersionResponseDTO(Version version);
    List<VersionResponseDTO> toListVersionResponseDTO(List<Version> versions);
}
