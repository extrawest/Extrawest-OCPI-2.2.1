package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.dto.request.CommandResultRequestDTO;
import com.extrawest.ocpi.model.enums.CommandType;

public interface EMSPCommandsService {

    void postCommand(CommandResultRequestDTO commandResultRequestDTO, CommandType commandType, String uniqueId);

}
