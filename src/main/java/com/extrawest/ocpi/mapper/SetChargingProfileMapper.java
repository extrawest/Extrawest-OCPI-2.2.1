package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.SetChargingProfile;
import com.extrawest.ocpi.model.dto.request.SetChargingProfileRequestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SetChargingProfileMapper {
    SetChargingProfile toSetChargingProfileEntity(SetChargingProfileRequestDTO setChargingProfileRequestDTO);
    SetChargingProfileRequestDTO toSetChargingProfileRequestDTO(SetChargingProfile setChargingProfile);
    List<SetChargingProfileRequestDTO> toListSetChargingProfileRequestDTO(List<SetChargingProfile> setChargingProfiles);
    List<SetChargingProfile> toListSetChargingProfile(List<SetChargingProfileRequestDTO> setChargingProfileRequestDTOS);
}
