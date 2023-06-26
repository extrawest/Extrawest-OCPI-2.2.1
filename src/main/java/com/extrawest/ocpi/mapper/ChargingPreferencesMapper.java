package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.ChargingPreferences;
import com.extrawest.ocpi.model.dto.ChargingPreferencesDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChargingPreferencesMapper {
    ChargingPreferencesDTO toChargingPreferencesDTO (ChargingPreferences chargingPreferences);
    ChargingPreferences toChargingPreferencesEntity (ChargingPreferencesDTO chargingPreferencesDTO);
}
