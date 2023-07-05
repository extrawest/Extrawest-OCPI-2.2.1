package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.AbstractCommand;
import com.extrawest.ocpi.model.dto.response.CommandResponseDTO;
import com.extrawest.ocpi.model.enums.CommandType;

public interface CPOCommandsService {

    CommandResponseDTO postCommand(CommandType command, AbstractCommand requestedCommand);

}
