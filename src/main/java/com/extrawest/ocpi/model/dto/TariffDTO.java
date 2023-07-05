package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.TariffType;
import com.extrawest.ocpi.model.vo.DisplayText;
import com.extrawest.ocpi.model.vo.EnergyMix;
import com.extrawest.ocpi.model.vo.Price;
import com.extrawest.ocpi.model.vo.TariffElement;
import com.extrawest.ocpi.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffDTO {
    @NotBlank
    @Size(min = 1, max = 2)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("country_code")
    private String countryCode;
    @NotBlank
    @Size(min = 1, max = 3)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("party_id")
    private String partyId;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    private String id;
    @NotBlank
    @Size(min = 1, max = 3)
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
    @NotBlank
    private List<TariffElement> elements;
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;
    @JsonProperty("end_date_time")
    private LocalDateTime endDateTime;
    @JsonProperty("energy_mix")
    private EnergyMix energyMix;
    @NotBlank
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
