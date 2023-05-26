package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.dto.request.TariffRequestDTO;
import com.extrawest.ocpi_emsp_prototype.model.dto.response.TariffResponseDTO;
import com.extrawest.ocpi_emsp_prototype.model.Tariff;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TariffMapper {
    Tariff toTariffEntity(TariffRequestDTO tariffRequestDTO);
    TariffResponseDTO toTariffResponseDTO(Tariff tariff);
    List<TariffResponseDTO> toListTariffResponseDTO(List<Tariff> tariffs);
    List<Tariff> toListTariff(List<TariffRequestDTO> tariffs);
}
