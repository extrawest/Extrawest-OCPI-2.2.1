package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.dto.response.VersionDetailsResponseDTO;
import com.extrawest.ocpi.model.dto.response.VersionResponseDTO;
import com.extrawest.ocpi.model.enums.VersionNumber;
import com.extrawest.ocpi.service.cpo.CPOVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cpo/api/2.2.1/versions")
public class CPOVersionController {

    protected final CPOVersionService cpoVersionService;

    protected CPOVersionController(@Autowired CPOVersionService cpoVersionService) {
        this.cpoVersionService = cpoVersionService;
    }

    /**
     * Fetch information about the supported versions.
     * @return list of VersionResponseDTO
     */
    @GetMapping
    public ResponseEntity<List<VersionResponseDTO>> getVersion() {
        return ResponseEntity.ok(cpoVersionService.getVersion());
    };

    /**
     * Via the version details, the parties can exchange which modules are implemented for a specific version of OCPI,
     * which interfacevrole is implemented, and what the endpoint URL is for this interface.
     * @param version - version of OCPI
     * @return VersionDetails
     */
    @GetMapping("/details/{version}")
    public ResponseEntity<VersionDetailsResponseDTO> getVersionDetails(
            @PathVariable(value = "version") VersionNumber version
    ) {
        return ResponseEntity.ok(cpoVersionService.getVersionDetails(version));
    };
}
