package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.ClientInfo;
import com.extrawest.ocpi_emsp_prototype.model.dto.ClientInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientInfoMapper {
    ClientInfo toClientInfoEntity(ClientInfoDTO clientInfoDTO);
    ClientInfoDTO toClientInfoDTO(ClientInfo clientInfo);
}
