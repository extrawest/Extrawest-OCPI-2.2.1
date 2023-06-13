package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.AuthorizationInfo;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.AuthorizationInfoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorizationInfoMapper {
    AuthorizationInfo toAuthorizationInfoEntity(AuthorizationInfoResponseDTO authorizationInfoResponseDTO);
    AuthorizationInfoResponseDTO toAuthorizationInfoResponseDTO(AuthorizationInfo authorizationInfo);
}
