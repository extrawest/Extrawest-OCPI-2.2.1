package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.dto.response.VersionDetailsResponseDTO;
import com.extrawest.ocpi.model.dto.response.VersionResponseDTO;
import com.extrawest.ocpi.model.enums.VersionNumber;

import java.util.List;

public interface CPOVersionService {

    List<VersionResponseDTO> getVersion();
    VersionDetailsResponseDTO getVersionDetails(VersionNumber version);

}
