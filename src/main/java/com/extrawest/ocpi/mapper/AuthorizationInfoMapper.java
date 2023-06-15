package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.AuthorizationInfo;
import com.extrawest.ocpi.model.dto.response.AuthorizationInfoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorizationInfoMapper {
    AuthorizationInfo toAuthorizationInfoEntity(AuthorizationInfoResponseDTO authorizationInfoResponseDTO);
    AuthorizationInfoResponseDTO toAuthorizationInfoResponseDTO(AuthorizationInfo authorizationInfo);
}
