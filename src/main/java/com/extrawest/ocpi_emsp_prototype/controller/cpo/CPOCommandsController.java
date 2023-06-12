package com.extrawest.ocpi_emsp_prototype.controller.cpo;

import com.extrawest.ocpi_emsp_prototype.model.AbstractCommand;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.CommandResponseDTO;
import com.extrawest.ocpi_emsp_prototype.model.enums.CommandType;
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
