package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.enums.Facility;
import com.extrawest.ocpi.model.enums.ParkingType;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    @NotBlank
    @Size(min = 1, max = 2)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("country_code")
    private String countryCode;
    @NotBlank
    @Size(min = 1, max = 3)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    @JsonProperty("party_id")
    private String partyId;
    @NotBlank
    @Size(min = 1, max = 36)
    @Pattern(regexp = Constants.ASCII_REGEXP)
    private String id;
    @NotBlank
    private Boolean publish;
    @JsonProperty("publish_allowed_to")
    private List<PublishTokenType> publishAllowedTo;
    @Size(min = 1, max = 255)
    private String name;
    @Size(min = 1, max = 45)
    private String address;
    @Size(min = 1, max = 45)
    private String city;
    @Size(min = 1, max = 10)
    @JsonProperty("postal_code")
    private String postalCode;
    @Size(min = 1, max = 20)
    private String state;
    @Size(min = 1, max = 3)
    private String country;
    @NotBlank
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
    @NotBlank
    @Size(min = 1, max = 255)
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("opening_times")
    private Hours openingTimes;
    @JsonProperty("charging_when_closed")
    private Boolean chargingWhenClosed;
    private List<Image> images;
    @JsonProperty("energy_mix")
    private EnergyMix energyMix;
    @NotBlank
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
