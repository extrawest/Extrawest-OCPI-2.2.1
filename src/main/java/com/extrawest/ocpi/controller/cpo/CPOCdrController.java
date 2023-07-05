package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.dto.CdrDTO;
import com.extrawest.ocpi.service.cpo.CPOCdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cpo/api/2.2.1/cdr")
public class CPOCdrController {

    protected final CPOCdrService cpoCdrService;

    protected CPOCdrController(@Autowired CPOCdrService cpoCdrService) {
        this.cpoCdrService = cpoCdrService;
    }

    /**
     * Fetch CDRs from the CPO’s system.
     * @param dateFrom Only return CDRs that have last_updated after or equal to this Date/Time (inclusive).
     * @param dateTo Only return CDRs that have last_updated up to this Date/Time, but not including (exclusive).
     * @param offset The offset of the first object returned. Default is 0.
     * @param limit Maximum number of objects to GET.
     * @return The endpoint returns a list of CDRs matching the given parameters in the GET request, the header
     * will contain the pagination related headers.
     */
    @GetMapping
    public ResponseEntity<List<CdrDTO>> getCdr(
            @RequestParam(value = "date_from") LocalDateTime dateFrom,
            @RequestParam(value = "date_to") LocalDateTime dateTo,
            @RequestParam(value = "offset") Integer offset,
            @RequestParam(value = "limit") Integer limit
    ) {
        return ResponseEntity.ok(cpoCdrService.getCdr(dateFrom, dateTo, offset, limit));
    };
}
