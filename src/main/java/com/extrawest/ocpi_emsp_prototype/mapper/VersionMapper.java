package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.Version;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.VersionResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VersionMapper {
    VersionResponseDTO toVersionResponseDTO(Version version);
    List<VersionResponseDTO> toListVersionResponseDTO(List<Version> versions);
}
