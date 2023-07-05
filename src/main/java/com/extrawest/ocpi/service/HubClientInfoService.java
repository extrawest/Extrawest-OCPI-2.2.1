package com.extrawest.ocpi.service;

import com.extrawest.ocpi.model.dto.ClientInfoDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface HubClientInfoService {

    List<ClientInfoDTO> getClientInfoList(LocalDateTime dateFrom, LocalDateTime dateTo, Integer offset, Integer limit);

}
