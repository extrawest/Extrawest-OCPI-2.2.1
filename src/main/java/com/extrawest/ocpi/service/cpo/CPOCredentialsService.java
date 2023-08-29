package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.dto.CredentialsDTO;

public interface CPOCredentialsService {

    CredentialsDTO getCredentials();
    void postCredentials (CredentialsDTO credentialsDTO);
    void putCredentials(CredentialsDTO credentialsDTO);
    void deleteCredentials(CredentialsDTO credentialsDTO);

}
