package com.extrawest.ocpi.service.emsp;

import com.extrawest.ocpi.model.dto.TariffDTO;

public interface EMSPTariffService {

    TariffDTO getTariff(String countryCode, String partyId, String tariffId);
    void saveTariff(TariffDTO tariffDTO, String countryCode, String partyId, String tariff_id);
    void deleteTariff(String countryCode, String partyId, String tariff_id);

}
