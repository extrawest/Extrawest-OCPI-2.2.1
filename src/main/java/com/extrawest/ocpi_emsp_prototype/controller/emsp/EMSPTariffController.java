package com.extrawest.ocpi_emsp_prototype.controller.emsp;

import com.extrawest.ocpi_emsp_prototype.model.dto.request.TariffRequestDTO;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.TariffResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emsp/api/tariffs")
public abstract class EMSPTariffController {

    /**
     * Retrieve a Tariff as it is stored in the eMSP’s system.
     * @param countryCode Country code of the CPO performing the GET request on the eMSP’s system.
     * @param partyId Party ID (Provider ID) of the CPO performing the GET request on the eMSP’s system.
     * @param tariff_id Party ID (Provider ID) of the CPO performing the GET request on the eMSP’s system.
     * @return The requested Tariff object.
     */
    @GetMapping("/getTariff")
    public abstract ResponseEntity<TariffResponseDTO> getTariff(
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String partyId,
            @RequestParam(value = "tariff_id") String tariff_id
    );

    /**
     * Push new/updated Tariff object to the eMSP.
     * @param tariffRequestDTO New or updated Tariff object.
     * @param countryCode Country code of the CPO performing the PUT request on the eMSP’s system. This SHALL be
     *                    the same value as the country_code in the Tariff object being pushed.
     * @param partyId Party ID (Provider ID) of the CPO performing the PUT request on the eMSP’s system. This SHALL be the same value as the party_id in the Tariff object being pushed.
     * @param tariff_id Tariff.id of the Tariff object to create or replace.
     */
    @PutMapping("/putTariff")
    public abstract void saveTariff(
            @RequestBody TariffRequestDTO tariffRequestDTO,
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String partyId,
            @RequestParam(value = "tariff_id") String tariff_id
    );

    /**
     * Delete a Tariff object which is not used any more and will not be used in the future.
     * @param countryCode Country code of the CPO performing the PUT request on the eMSP’s system.
     * @param partyId Party ID (Provider ID) of the CPO performing the PUT request on the eMSP’s system.
     * @param tariff_id Tariff.id of the Tariff object to delete.
     */
    @DeleteMapping("/deleteTariff")
    public abstract void deleteTariff(
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String partyId,
            @RequestParam(value = "tariff_id") String tariff_id
    );
}
