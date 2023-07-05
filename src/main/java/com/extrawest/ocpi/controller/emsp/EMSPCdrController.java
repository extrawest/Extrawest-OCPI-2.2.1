package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.CdrDTO;
import com.extrawest.ocpi.service.emsp.EMSPCdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/emsp/api/2.2.1/cdr")
public class EMSPCdrController {

    protected final EMSPCdrService emspCdrService;

    public EMSPCdrController(@Autowired EMSPCdrService emspCdrService) {
        this.emspCdrService = emspCdrService;
    }

    /**
     * Fetch CDRs from the receivers system.
     * @param id - id of CDR
     * @return The endpoint returns the requested CDR, if it exists.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CdrDTO> getCdr(
            @PathVariable(value = "id") String id
    ) {
        return ResponseEntity.ok(emspCdrService.getCdr(id));
    };

    @PostMapping
    public ResponseEntity<String> postCdr(
            @RequestBody @Valid CdrDTO cdrDTO
    ) {
        return ResponseEntity.ok(emspCdrService.postCdr(cdrDTO));
    };

}
