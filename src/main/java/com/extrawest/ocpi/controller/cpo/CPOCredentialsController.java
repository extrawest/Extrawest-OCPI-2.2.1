package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.dto.CredentialsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpo/api/2.2.1/credentials")
public abstract class CPOCredentialsController {
    /**
     * Retrieves the credentials object to access the server’s platform.
     * @return CredentialsDTO
     */
    @GetMapping
    public abstract ResponseEntity<CredentialsDTO> getCredentials();

    /**
     * Provides the server with a credentials object to access the client’s system (i.e. register).
     * @param credentialsDTO - credentials
     */
    @PostMapping
    public abstract void postCredentials(
            @RequestBody CredentialsDTO credentialsDTO
    );

    /**
     * Provides the server with an updated credentials object to access the client’s system.
     * @param credentialsDTO - credentials
     */
    @PutMapping
    public abstract void putCredentials(
            @RequestBody CredentialsDTO credentialsDTO
    );

    /**
     * Informs the server that its credentials to the client’s system are now invalid (i.e. unregister).
     * @param credentialsDTO - credentials
     */
    @DeleteMapping
    public abstract void deleteCredentials(
            @RequestBody CredentialsDTO credentialsDTO
    );
}
