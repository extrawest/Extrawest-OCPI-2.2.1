package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.dto.request.CommandResultRequestDTO;
import com.extrawest.ocpi.model.vo.CommandResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandResultMapper {
    CommandResult toCommandResultEntity(CommandResultRequestDTO commandResultRequestDTO);
    CommandResultRequestDTO toCommandResultRequestDTO(CommandResult commandResult);
}
