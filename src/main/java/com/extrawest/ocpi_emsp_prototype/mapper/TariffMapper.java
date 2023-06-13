package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.Tariff;
import com.extrawest.ocpi_emsp_prototype.model.dto.TariffDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TariffMapper {
    Tariff toTariffEntity(TariffDTO tariffDTO);
    TariffDTO toTariffDTO(Tariff tariff);
    List<TariffDTO> toListTariffDTO(List<Tariff> tariffs);
    List<Tariff> toListTariff(List<TariffDTO> tariffs);
}
