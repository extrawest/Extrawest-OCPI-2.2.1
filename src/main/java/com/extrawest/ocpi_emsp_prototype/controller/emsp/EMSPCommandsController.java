package com.extrawest.ocpi_emsp_prototype.controller.emsp;

import com.extrawest.ocpi_emsp_prototype.model.enums.CommandType;
import com.extrawest.ocpi_emsp_prototype.model.vo.CommandResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emsp/api/2.2.1/commands/{commandType}/{uniqueId}")
public abstract class EMSPCommandsController {
    public abstract void postCommand(
            @RequestBody CommandResult commandResult,
            @PathVariable CommandType commandType,
            @PathVariable String uniqueId
    );
}
