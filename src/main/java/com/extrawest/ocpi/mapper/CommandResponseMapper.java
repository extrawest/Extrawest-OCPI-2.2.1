package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.dto.response.CommandResponseDTO;
import com.extrawest.ocpi.model.vo.CommandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandResponseMapper {
    CommandResponse toCommandResponseEntity(CommandResponseDTO commandResponseDTO);
    CommandResponseDTO toCommandResponseDTO(CommandResponse commandResponse);
}
