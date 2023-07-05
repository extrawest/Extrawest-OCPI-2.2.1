package com.extrawest.ocpi.service.cpo;

import com.extrawest.ocpi.model.dto.TariffDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface CPOTariffService {
    List<TariffDTO> getAll(LocalDateTime dateFrom, LocalDateTime dateTo, Integer offset, Integer limit);

}
