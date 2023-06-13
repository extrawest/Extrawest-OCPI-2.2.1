package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.dto.request.ActiveChargingProfileRequestDTO;
import com.extrawest.ocpi_emsp_prototype.model.vo.ActiveChargingProfile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActiveChargingProfileMapper {
    ActiveChargingProfile toActiveChargingProfileEntity(ActiveChargingProfileRequestDTO activeChargingProfileRequestDTO);
    ActiveChargingProfileRequestDTO toActiveChargingProfileRequestDTO(ActiveChargingProfile activeChargingProfile);
    List<ActiveChargingProfileRequestDTO> toListActiveChargingProfileRequestDTO(List<ActiveChargingProfile> activeChargingProfiles);
    List<ActiveChargingProfile> toListActiveChargingProfile(List<ActiveChargingProfileRequestDTO> activeChargingProfileRequestDTOS);
}
