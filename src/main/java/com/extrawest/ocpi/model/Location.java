package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.Facility;
import com.extrawest.ocpi.model.enums.ParkingType;
import com.extrawest.ocpi.model.vo.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The Location object describes the location and its properties where a group of EVSEs that belong
 * together are installed. Typically, the Location object is the exact location of the group of EVSEs,
 * but it can also be the entrance of a parking garage which contains these EVSEs.
 * The exact way to reach each EVSE can be further specified by its own properties.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Location extends AbstractDomainObject implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();
    @JsonIgnore
    private final Validator countryCodeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string2())
                    .build();
    @JsonIgnore
    private final Validator partyIdValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();
    @JsonIgnore
    private final Validator idValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();
    @JsonIgnore
    private final Validator nameValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string255())
                    .build();
    @JsonIgnore
    private final Validator addressValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string45())
                    .build();
    @JsonIgnore
    private final Validator cityValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string45())
                    .build();
    @JsonIgnore
    private final Validator postalCodeValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string10())
                    .build();
    @JsonIgnore
    private final Validator stateValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string20())
                    .build();
    @JsonIgnore
    private final Validator countryValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string3())
                    .build();
    @JsonIgnore
    private final Validator timeZoneValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();

    /**
     * ISO-3166 alpha-2 country code of the CPO that 'owns' this Location.
     */
    @JsonProperty("country_code")
    private String countryCode;
    /**
     * ID of the CPO that 'owns' this Location (following the ISO-15118 standard).
     */
    @JsonProperty("party_id")
    private String partyId;
    /**
     * Uniquely identifies the location within the CPOs platform (and suboperator platforms).
     * This field can never be changed, modified or renamed.
     */
    @JsonProperty("id")
    private String id;
    /**
     * Defines if a Location may be published on an website or app etc. When this is set to false, only tokens
     * identified in the field: publish_allowed_to are allowed to be shown this Location.
     * When the same location has EVSEs that may be published and may not be published, two 'Locations' should be created.
     */
    @JsonProperty("publish")
    private Boolean publish;
    /**
     * This field may only be used when the publish field is set to false. Only owners of Tokens that match all the set
     * fields of one PublishToken in the list are allowed to be shown this location.
     */
    @JsonProperty("publish_allowed_to")
    private List<PublishTokenType> publishAllowedTo;
    /**
     * Display name of the location.
     */
    @JsonProperty("name")
    private String name;
    /**
     * Street/block name and house number if available.
     */
    @JsonProperty("address")
    private String address;
    /**
     * City or town.
     */
    @JsonProperty("city")
    private String city;
    /**
     * Postal code of the location, may only be omitted when the location has no postal code: in some countries charging
     * locations at highways don’t have postal codes.
     */
    @JsonProperty("postal_code")
    private String postalCode;
    /**
     * State or province of the location, only to be used when relevant.
     */
    @JsonProperty("state")
    private String state;
    /**
     * ISO 3166-1 alpha-3 code for the country of this location.
     */
    @JsonProperty("country")
    private String country;
    /**
     * Coordinates of the location.
     */
    @JsonProperty("coordinates")
    private GeoLocation coordinates;
    /**
     * Geographical location of related points relevant to the user.
     */
    @JsonProperty("related_locations")
    private List<AdditionalGeoLocation> relatedLocations;
    /**
     * The general type of parking at the charge point location.
     */
    @JsonProperty("parking_type")
    private ParkingType parkingType;
    /**
     * List of EVSEs that belong to this Location.
     */
    @JsonProperty("evses")
    private List<EVSE> evses;
    /**
     * Human-readable directions on how to reach the location.
     */
    @JsonProperty("directions")
    private List<DisplayText> directions;
    /**
     * Information of the operator. When not specified, the information retrieved from the Credentials module,
     * selected by the country_code and party_id of this Location, should be used instead.
     */
    @JsonProperty("operator")
    private BusinessDetails operator;
    /**
     * Information of the suboperator if available.
     */
    @JsonProperty("suboperator")
    private BusinessDetails subOperator;
    /**
     * Information of the owner if available.
     */
    @JsonProperty("owner")
    private BusinessDetails owner;
    /**
     * Optional list of facilities this charging location directly belongs to.
     */
    @JsonProperty("facilities")
    private List<Facility> facilities;
    /**
     * One of IANA tzdata’s TZ-values representing the time zone of the location.
     * Examples: "Europe/Oslo", "Europe/Zurich". (http://www.iana.org/time-zones)
     */
    @JsonProperty("time_zone")
    private String timeZone;
    /**
     * The times when the EVSEs at the location can be accessed for charging.
     */
    @JsonProperty("opening_times")
    private Hours openingTimes;
    /**
     * Indicates if the EVSEs are still charging outside the opening hours of the location.
     * E.g. when the parking garage closes its barriers over night, is it allowed to charge till the next morning?
     * Default: true
     */
    @JsonProperty("charging_when_closed")
    private Boolean chargingWhenClosed = true;
    /**
     * Links to images related to the location such as photos or logos.
     */
    @JsonProperty("images")
    private List<Image> images;
    /**
     * Details on the energy supplied at this location.
     */
    @JsonProperty("energy_mix")
    private EnergyMix energyMix;
    /**
     * Timestamp when this Location or one of its EVSEs or Connectors were last updated (or created).
     */
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;

    public void setCountryCode(String countryCode) {
        countryCodeValidator.validate(countryCode);
        this.countryCode = countryCode;
    }

    public void setPartyId(String partyId) {
        partyIdValidator.validate(partyId);
        this.partyId = partyId;
    }

    public void setId(String id) {
        idValidator.validate(id);
        this.id = id;
    }

    public void setPublish(Boolean publish) {
        requiredValidator.validate(publish);
        this.publish = publish;
    }

    public void setPublishAllowedTo(List<PublishTokenType> publishAllowedTo) {
        this.publishAllowedTo = publishAllowedTo;
    }

    public void setName(String name) {
        nameValidator.validate(name);
        this.name = name;
    }

    public void setAddress(String address) {
        addressValidator.validate(address);
        this.address = address;
    }

    public void setCity(String city) {
        cityValidator.validate(city);
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        postalCodeValidator.validate(postalCode);
        this.postalCode = postalCode;
    }

    public void setState(String state) {
        stateValidator.validate(state);
        this.state = state;
    }

    public void setCountry(String country) {
        countryValidator.validate(country);
        this.country = country;
    }

    public void setCoordinates(GeoLocation coordinates) {
        requiredValidator.validate(coordinates);
        this.coordinates = coordinates;
    }

    public void setRelatedLocations(List<AdditionalGeoLocation> relatedLocations) {
        this.relatedLocations = relatedLocations;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public void setEvses(List<EVSE> evses) {
        this.evses = evses;
    }

    public void setDirections(List<DisplayText> directions) {
        this.directions = directions;
    }

    public void setOperator(BusinessDetails operator) {
        this.operator = operator;
    }

    public void setSubOperator(BusinessDetails subOperator) {
        this.subOperator = subOperator;
    }

    public void setOwner(BusinessDetails owner) {
        this.owner = owner;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public void setTimeZone(String timeZone) {
        requiredValidator.validate(timeZone);
        this.timeZone = timeZone;
    }

    public void setOpeningTimes(Hours openingTimes) {
        this.openingTimes = openingTimes;
    }

    public void setChargingWhenClosed(Boolean chargingWhenClosed) {
        this.chargingWhenClosed = chargingWhenClosed;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setEnergyMix(EnergyMix energyMix) {
        this.energyMix = energyMix;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        requiredValidator.validate(lastUpdated);
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean validate() {
        return countryCodeValidator.safeValidate(countryCode)
                && partyIdValidator.safeValidate(partyId)
                && idValidator.safeValidate(id)
                && requiredValidator.safeValidate(publish)
                && addressValidator.safeValidate(address)
                && cityValidator.safeValidate(city)
                && countryValidator.safeValidate(country)
                && requiredValidator.safeValidate(coordinates)
                && coordinates.validate()
                && timeZoneValidator.safeValidate(timeZone)
                && requiredValidator.safeValidate(lastUpdated);
    }
}
