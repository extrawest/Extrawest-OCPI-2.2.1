package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.enums.TariffType;
import com.extrawest.ocpi_emsp_prototype.model.vo.DisplayText;
import com.extrawest.ocpi_emsp_prototype.model.vo.EnergyMix;
import com.extrawest.ocpi_emsp_prototype.model.vo.Price;
import com.extrawest.ocpi_emsp_prototype.model.vo.TariffElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffResponseDTO {
    private String countryCode;
    private String partyId;
    private String id;
    private String currency;
    private TariffType type;
    private List<DisplayText> tariffAltText;
    private String tariffAltUrl;
    private Price minPrice;
    private Price maxPrice;
    private List<TariffElement> elements;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private EnergyMix energyMix;
    private LocalDateTime lastUpdated;
}
