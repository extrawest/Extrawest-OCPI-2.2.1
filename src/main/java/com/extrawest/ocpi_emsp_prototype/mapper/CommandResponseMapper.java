package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.dto.response.CommandResponseDTO;
import com.extrawest.ocpi_emsp_prototype.model.vo.CommandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandResponseMapper {
    CommandResponse toCommandResponseEntity(CommandResponseDTO commandResponseDTO);
    CommandResponseDTO toCommandResponseDTO(CommandResponse commandResponse);
}
