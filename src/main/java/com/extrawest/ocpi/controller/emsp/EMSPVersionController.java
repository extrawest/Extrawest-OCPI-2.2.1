package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.response.VersionDetailsResponseDTO;
import com.extrawest.ocpi.model.dto.response.VersionResponseDTO;
import com.extrawest.ocpi.model.enums.VersionNumber;
import com.extrawest.ocpi.service.emsp.EMSPVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emsp/api/2.2.1/versions")
public class EMSPVersionController {

    protected final EMSPVersionService emspVersionService;

    public EMSPVersionController(@Autowired EMSPVersionService emspVersionService) {
        this.emspVersionService = emspVersionService;
    }

    /**
     * Fetch information about the supported versions.
     * @return list of VersionResponseDTO
     */
    public ResponseEntity<List<VersionResponseDTO>> getVersion() {
        return ResponseEntity.ok(emspVersionService.getVersion());
    };

    /**
     * Via the version details, the parties can exchange which modules are implemented for a specific version of OCPI,
     * which interface role is implemented, and what the endpoint URL is for this interface.
     * @param version - version of OCPI
     * @return VersionDetails
     */
    @GetMapping("/details/{version}")
    public ResponseEntity<VersionDetailsResponseDTO> getVersionDetails(
            @PathVariable(value = "version") VersionNumber version
    ) {
        return ResponseEntity.ok(emspVersionService.getVersionDetails(version));
    };
}
