package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.Credentials;
import com.extrawest.ocpi.model.dto.CredentialsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
    Credentials toCredentialsEntity(CredentialsDTO credentialsDTO);
    CredentialsDTO toCredentialsDTO(Credentials credentials);
}
