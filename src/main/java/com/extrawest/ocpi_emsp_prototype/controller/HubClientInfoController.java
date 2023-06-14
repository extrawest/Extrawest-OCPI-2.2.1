package com.extrawest.ocpi_emsp_prototype.controller;

import com.extrawest.ocpi_emsp_prototype.model.dto.ClientInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/hub/api/2.2.1/hubClientInfo")
public abstract class HubClientInfoController {

    /**
     * Get the list of known ClientInfo objects, last updated between the {date_from} and {date_to} paginated)
     * @param dateFrom Only return ClientInfo that have last_updated after or equal to this Date/Time (inclusive).
     * @param dateTo Only return ClientInfo that have last_updated up to this Date/Time, but not including (exclusive).
     * @param offset The offset of the first object returned. Default is 0.
     * @param limit Maximum number of objects to GET.
     * @return List of all (or matching) ClientInfo objects.
     */
    @GetMapping("/{date_from}/{date_to}/{offset}/{limit}")
    public abstract ResponseEntity<List<ClientInfoDTO>> getClientInfoList(
            @PathVariable(value = "date_from", required = false) LocalDateTime dateFrom,
            @PathVariable (value = "date_to", required = false) LocalDateTime dateTo,
            @PathVariable (value = "offset", required = false) Integer offset,
            @PathVariable (value = "limit", required = false) Integer limit
    );

}
