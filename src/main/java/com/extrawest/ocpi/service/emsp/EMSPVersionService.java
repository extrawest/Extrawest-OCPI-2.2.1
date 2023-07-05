package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.dto.response.VersionDetailsResponseDTO;
import com.extrawest.ocpi.model.dto.response.VersionResponseDTO;
import com.extrawest.ocpi.model.enums.VersionNumber;

import java.util.List;

public interface EMSPVersionService {

    List<VersionResponseDTO> getVersion();
    VersionDetailsResponseDTO getVersionDetails(VersionNumber version);

}
