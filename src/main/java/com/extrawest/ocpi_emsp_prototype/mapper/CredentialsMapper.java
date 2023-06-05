package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.Credentials;
import com.extrawest.ocpi_emsp_prototype.model.dto.CredentialsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
    Credentials toCredentialsEntity(CredentialsDTO credentialsDTO);
    CredentialsDTO toTCredentialsDTO(Credentials credentials);
}
