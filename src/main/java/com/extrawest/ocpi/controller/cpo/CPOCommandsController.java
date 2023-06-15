package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.enums.CommandType;
import com.extrawest.ocpi.model.AbstractCommand;
import com.extrawest.ocpi.model.dto.response.CommandResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpo/api/2.2.1/commands")
public abstract class CPOCommandsController {
    /**
     *
     * @param command
     * @return
     */
    @PostMapping("/{command}")
    public abstract ResponseEntity<CommandResponseDTO> postCommand(
            @PathVariable(value = "command") CommandType command,
            @RequestBody AbstractCommand requestedCommand
    );
}
