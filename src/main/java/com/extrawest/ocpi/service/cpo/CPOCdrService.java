package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.dto.CdrDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CPOCdrService {
    List<CdrDTO> getCdr(LocalDateTime dateFrom, LocalDateTime dateTo, Integer offset, Integer limit);

}
