package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.VersionDetails;
import com.extrawest.ocpi.model.dto.response.VersionDetailsResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VersionDetailsMapper {
    VersionDetailsResponseDTO toVersionDetailsDTO(VersionDetails versionDetails);
    List<VersionDetailsResponseDTO> toListVersionDetailsResponseDTO(List<VersionDetails> versionDetails);
}
