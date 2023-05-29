package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.VersionDetails;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.VersionDetailsResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VersionDetailsMapper {
    VersionDetailsResponseDTO toVersionDetailsDTO(VersionDetails versionDetails);
    List<VersionDetailsResponseDTO> toListVersionDetailsResponseDTO(List<VersionDetails> versionDetails);
}
