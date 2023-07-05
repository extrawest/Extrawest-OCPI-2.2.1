package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.CredentialsDTO;
import com.extrawest.ocpi.service.emsp.EMSPCredentialsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emsp/api/2.2.1/credentials")
public class EMSPCredentialsController {

    protected final EMSPCredentialsService emspCredentialsService;

    protected EMSPCredentialsController(@Autowired EMSPCredentialsService emspCredentialsService) {
        this.emspCredentialsService = emspCredentialsService;
    }

    /**
     * Retrieves the credentials object to access the server’s platform.
     * @return CredentialsDTO
     */
    @GetMapping
    public ResponseEntity<CredentialsDTO> getCredentials() {
        return ResponseEntity.ok(emspCredentialsService.getCredentials());
    };

    /**
     * Provides the server with a credentials object to access the client’s system (i.e. register).
     * @param credentialsDTO - credentials
     */
    @PostMapping
    public void postCredentials(
            @RequestBody @Valid CredentialsDTO credentialsDTO
    ) {
        emspCredentialsService.postCredentials(credentialsDTO);
    };

    /**
     * Provides the server with an updated credentials object to access the client’s system.
     * @param credentialsDTO - credentials
     */
    @PutMapping
    public void putCredentials(
            @RequestBody @Valid CredentialsDTO credentialsDTO
    ) {
        emspCredentialsService.putCredentials(credentialsDTO);
    };

    /**
     * Informs the server that its credentials to the client’s system are now invalid (i.e. unregister).
     * @param credentialsDTO - credentials
     */
    @DeleteMapping
    public void deleteCredentials(
            @RequestBody @Valid CredentialsDTO credentialsDTO
    ) {
        emspCredentialsService.deleteCredentials(credentialsDTO);
    };
}
