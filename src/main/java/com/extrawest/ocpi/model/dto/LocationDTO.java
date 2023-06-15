package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.Facility;
import com.extrawest.ocpi.model.enums.ParkingType;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.model.vo.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("party_id")
    private String partyId;
    private String id;
    private Boolean publish;
    @JsonProperty("publish_allowed_to")
    private List<PublishTokenType> publishAllowedTo;
    private String name;
    private String address;
    private String city;
    @JsonProperty("postal_code")
    private String postalCode;
    private String state;
    private String country;
    private GeoLocation coordinates;
    @JsonProperty("related_locations")
    private List<AdditionalGeoLocation> relatedLocations;
    @JsonProperty("parking_type")
    private ParkingType parkingType;
    private List<EVSE> evses;
    private List<DisplayText> directions;
    private BusinessDetails operator;
    private BusinessDetails subOperator;
    private BusinessDetails owner;
    private List<Facility> facilities;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("opening_times")
    private Hours openingTimes;
    @JsonProperty("charging_when_closed")
    private Boolean chargingWhenClosed;
    private List<Image> images;
    @JsonProperty("energy_mix")
    private EnergyMix energyMix;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
