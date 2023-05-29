package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.vo.*;
import com.extrawest.ocpi_emsp_prototype.model.enums.Facility;
import com.extrawest.ocpi_emsp_prototype.model.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseDTO {
    private String countryCode;
    private String partyId;
    private String id;
    private Boolean publish;
    private List<PublishTokenType> publishAllowedTo;
    private String name;
    private String address;
    private String city;
    private String postalCode;
    private String state;
    private String country;
    private GeoLocation coordinates;
    private List<AdditionalGeoLocation> relatedLocations;
    private ParkingType parkingType;
    private List<EVSE> evses;
    private List<DisplayText> directions;
    private BusinessDetails operator;
    private BusinessDetails subOperator;
    private BusinessDetails owner;
    private List<Facility> facilities;
    private String timeZone;
    private Hours openingTimes;
    private Boolean chargingWhenClosed;
    private List<Image> images;
    private EnergyMix energyMix;
    private LocalDateTime lastUpdated;
}
