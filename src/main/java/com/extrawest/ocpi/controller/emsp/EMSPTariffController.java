package com.extrawest.ocpi.controller.emsp;

import com.extrawest.ocpi.model.dto.TariffDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emsp/api/2.2.1/tariffs")
public abstract class EMSPTariffController {

    /**
     * Retrieve a Tariff as it is stored in the eMSP’s system.
     * @param countryCode Country code of the CPO performing the GET request on the eMSP’s system.
     * @param partyId Party ID (Provider ID) of the CPO performing the GET request on the eMSP’s system.
     * @param tariff_id Party ID (Provider ID) of the CPO performing the GET request on the eMSP’s system.
     * @return The requested Tariff object.
     */
    @GetMapping
    public abstract ResponseEntity<TariffDTO> getTariff(
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String partyId,
            @RequestParam(value = "tariff_id") String tariff_id
    );

    /**
     * Push new/updated Tariff object to the eMSP.
     * @param tariffDTO New or updated Tariff object.
     * @param countryCode Country code of the CPO performing the PUT request on the eMSP’s system. This SHALL be
     *                    the same value as the country_code in the Tariff object being pushed.
     * @param partyId Party ID (Provider ID) of the CPO performing the PUT request on the eMSP’s system. This SHALL be the same value as the party_id in the Tariff object being pushed.
     * @param tariff_id Tariff.id of the Tariff object to create or replace.
     */
    @PutMapping
    public abstract void saveTariff(
            @RequestBody TariffDTO tariffDTO,
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
    @DeleteMapping
    public abstract void deleteTariff(
            @RequestParam(value = "country_code") String countryCode,
            @RequestParam(value = "party_id") String partyId,
            @RequestParam(value = "tariff_id") String tariff_id
    );
}
