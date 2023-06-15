package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.TariffType;
import com.extrawest.ocpi.model.vo.DisplayText;
import com.extrawest.ocpi.model.vo.EnergyMix;
import com.extrawest.ocpi.model.vo.Price;
import com.extrawest.ocpi.model.vo.TariffElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffDTO {
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("party_id")
    private String partyId;
    private String id;
    private String currency;
    private TariffType type;
    @JsonProperty("tariff_alt_text")
    private List<DisplayText> tariffAltText;
    @JsonProperty("tariff_alt_url")
    private String tariffAltUrl;
    @JsonProperty("min_price")
    private Price minPrice;
    @JsonProperty("max_price")
    private Price maxPrice;
    private List<TariffElement> elements;
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;
    @JsonProperty("energy_mix")
    private EnergyMix energyMix;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
