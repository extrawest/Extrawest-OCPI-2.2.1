package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.request.CommandResultRequestDTO;
import com.extrawest.ocpi.model.enums.CommandType;
import com.extrawest.ocpi.service.emsp.EMSPCommandsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emsp/api/2.2.1/commands/{commandType}/{uniqueId}")
public class EMSPCommandsController {

    protected final EMSPCommandsService emspCommandsService;

    protected EMSPCommandsController(@Autowired EMSPCommandsService emspCommandsService) {
        this.emspCommandsService = emspCommandsService;
    }

    /**
     * It is up to the implementation of the eMSP to determine what parameters are put in the URL.
     * The eMSP sends a URL in the POST method body to the CPO. The CPO is required to use this URL for
     * the asynchronous response by the Charge Point. It is advised to make this URL unique for
     * every request to differentiate simultaneous commands, for example by adding a unique id as a URL segment.
     * @param commandResult Result of the command request, from the Charge Point.
     * @param commandType type of command
     * @param uniqueId It is advised to make this URL unique for every request to differentiate simultaneous commands,
     * for example by adding a unique id as a URL segment.
     */
    public void postCommand(
            @RequestBody @Valid CommandResultRequestDTO commandResult,
            @PathVariable CommandType commandType,
            @PathVariable String uniqueId
    ) {
        emspCommandsService.postCommand(commandResult, commandType, uniqueId);
    };
}
