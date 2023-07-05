package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.dto.CredentialsDTO;

public interface EMSPCredentialsService {

    CredentialsDTO getCredentials();
    void postCredentials(CredentialsDTO credentialsDTO);
    void putCredentials(CredentialsDTO credentialsDTO);
    void deleteCredentials(CredentialsDTO credentialsDTO);

}
