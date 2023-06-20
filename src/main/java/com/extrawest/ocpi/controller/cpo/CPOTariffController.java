package com.extrawest.ocpi.controller.cpo;

import com.extrawest.ocpi.model.dto.TariffDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cpo/api/2.2.1/tariffs")
public abstract class CPOTariffController {

    /**
     * Returns Tariff objects from the CPO, last updated between the {date_from} and {date_to} (paginated)
     * @param dateFrom Only return Tariffs that have last_updated after or equal to this Date/Time (inclusive).
     * @param dateTo Only return Tariffs that have last_updated up to this Date/Time, but not including (exclusive).
     * @param offset The offset of the first object returned. Default is 0.
     * @param limit Maximum number of objects to GET
     * @return List of all tariffs.
     */
    @GetMapping
    public abstract ResponseEntity<List<TariffDTO>> getTariffs(
            @RequestParam(value = "date_from", required = false) LocalDateTime dateFrom,
            @RequestParam(value = "date_to", required = false) LocalDateTime dateTo,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false) Integer limit
    );
}
