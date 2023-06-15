package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.CdrDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emsp/api/2.2.1/cdr")
public abstract class EMSPCdrController {

    /**
     * Fetch CDRs from the receivers system.
     * @param id - id of CDR
     * @return The endpoint returns the requested CDR, if it exists.
     */
    @GetMapping("/{id}")
    public abstract ResponseEntity<CdrDTO> getCdr(
            @PathVariable(value = "id") String id
    );

    @PostMapping
    public abstract ResponseEntity<String> postCdr(
            @RequestBody CdrDTO cdrDTO
    );

}
