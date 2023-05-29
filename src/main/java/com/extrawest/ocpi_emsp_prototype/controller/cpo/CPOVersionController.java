package com.extrawest.ocpi_emsp_prototype.controller.cpo;

import com.extrawest.ocpi_emsp_prototype.model.VersionDetails;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.VersionDetailsResponseDTO;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.VersionResponseDTO;
import com.extrawest.ocpi_emsp_prototype.model.enums.VersionNumber;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cpo/api/versions")
public abstract class CPOVersionController {
    /**
     * Fetch information about the supported versions.
     * @return list of VersionResponseDTO
     */
    @GetMapping
    public abstract ResponseEntity<List<VersionResponseDTO>> getVersion();

    /**
     * Via the version details, the parties can exchange which modules are implemented for a specific version of OCPI,
     * which interfacevrole is implemented, and what the endpoint URL is for this interface.
     * @param version - version of OCPI
     * @return VersionDetails
     */
    @GetMapping("/details/{version}")
    public abstract ResponseEntity<VersionDetailsResponseDTO> getVersionDetails(
            @PathVariable(value = "version") VersionNumber version
    );
}
