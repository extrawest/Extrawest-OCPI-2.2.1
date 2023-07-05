package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.AbstractCommand;
import com.extrawest.ocpi.model.dto.response.CommandResponseDTO;
import com.extrawest.ocpi.model.enums.CommandType;
import com.extrawest.ocpi.service.cpo.CPOCommandsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpo/api/2.2.1/commands")
public class CPOCommandsController {

    protected final CPOCommandsService cpoCommandsService;

    protected CPOCommandsController(@Autowired CPOCommandsService cpoCommandsService) {
        this.cpoCommandsService = cpoCommandsService;
    }

    /**
     * Send a command to the CPO, requesting the CPO to send the command to the Charge Point
     * @param command Type of command that is requested.
     * @param requestedCommand Depending on the command parameter the body SHALL contain the applicable object
     * for that command.
     * @return Result of the command request, by the CPO (not the Charge Point). So this indicates if the CPO understood
     * the command request and was able to send it to the Charge Point. This is not the response by the Charge Point
     */
    @PostMapping("/{command}")
    public ResponseEntity<CommandResponseDTO> postCommand(
            @PathVariable(value = "command") CommandType command,
            @RequestBody @Valid AbstractCommand requestedCommand
    ) {
        return ResponseEntity.ok(cpoCommandsService.postCommand(command, requestedCommand));
    };
}
