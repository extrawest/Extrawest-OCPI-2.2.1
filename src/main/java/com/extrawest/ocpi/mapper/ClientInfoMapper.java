package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.ClientInfo;
import com.extrawest.ocpi.model.dto.ClientInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientInfoMapper {
    ClientInfo toClientInfoEntity(ClientInfoDTO clientInfoDTO);
    ClientInfoDTO toClientInfoDTO(ClientInfo clientInfo);
}
