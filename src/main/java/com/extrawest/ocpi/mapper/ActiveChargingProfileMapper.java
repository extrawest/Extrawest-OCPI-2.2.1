package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.vo.ActiveChargingProfile;
import com.extrawest.ocpi.model.dto.request.ActiveChargingProfileRequestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActiveChargingProfileMapper {
    ActiveChargingProfile toActiveChargingProfileEntity(ActiveChargingProfileRequestDTO activeChargingProfileRequestDTO);
    ActiveChargingProfileRequestDTO toActiveChargingProfileRequestDTO(ActiveChargingProfile activeChargingProfile);
    List<ActiveChargingProfileRequestDTO> toListActiveChargingProfileRequestDTO(List<ActiveChargingProfile> activeChargingProfiles);
    List<ActiveChargingProfile> toListActiveChargingProfile(List<ActiveChargingProfileRequestDTO> activeChargingProfileRequestDTOS);
}
