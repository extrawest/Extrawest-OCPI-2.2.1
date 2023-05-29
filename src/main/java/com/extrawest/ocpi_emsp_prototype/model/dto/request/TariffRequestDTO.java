package com.extrawest.ocpi_emsp_prototype.model.dto.request;

import com.extrawest.ocpi_emsp_prototype.model.vo.DisplayText;
import com.extrawest.ocpi_emsp_prototype.model.vo.EnergyMix;
import com.extrawest.ocpi_emsp_prototype.model.vo.Price;
import com.extrawest.ocpi_emsp_prototype.model.vo.TariffElement;
import com.extrawest.ocpi_emsp_prototype.model.enums.TariffType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffRequestDTO {
    private String country_code;
    private String party_id;
    private String id;
    private String currency;
    private TariffType type;
    private List<DisplayText> tariff_alt_text;
    private String tariff_alt_url;
    private Price min_price;
    private Price max_price;
    private List<TariffElement> elements;
    private LocalDateTime start_date_time;
    private LocalDateTime end_date_time;
    private EnergyMix energy_mix;
    private LocalDateTime last_updated;
}
