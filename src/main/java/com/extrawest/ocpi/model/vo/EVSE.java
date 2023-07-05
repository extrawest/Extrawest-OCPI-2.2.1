package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.AbstractDomainObject;
import com.extrawest.ocpi.model.enums.ParkingRestriction;
import com.extrawest.ocpi.model.enums.Status;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.model.enums.Capability;
import com.extrawest.ocpi.validation.*;
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
 * The EVSE object describes the part that controls the power supply to a single EV in a single session.
 * It always belongs to a Location object. The object only contains directions to get from the location itself to the
 * EVSE (i.e. floor, physical_reference or directions).
 * When the directional properties of an EVSE are insufficient to reach the EVSE from the Location point,
 * then it typically indicates that the EVSE should be put in a different Location object
 * (sometimes with the same address but with different coordinates/directions).
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EVSE extends AbstractDomainObject implements Validatable {

    @JsonIgnore
    private final Validator uidValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();
    @JsonIgnore
    private final Validator evseIdValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string48())
                    .build();
    @JsonIgnore
    private final Validator floorLevelValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string16())
                    .build();
    @JsonIgnore
    private final Validator physicalReferenceValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string16())
                    .build();
    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();
    @JsonIgnore
    private final Validator connectorsValidator = new ListOfAtLeastOneObjects();
    /**
     * Uniquely identifies the EVSE within the CPOs platform (and suboperator platforms). For example a
     * database ID or the actual "EVSE ID". This field can never be changed, modified or renamed.
     * This is the 'technical' identification of the EVSE, not to be used as 'human readable' identification,
     * use the field evse_id for that. This field is named uid instead of id, because id could be confused
     * with evse_id which is an eMI3 defined field.
     */
    @JsonProperty("uid")
    private String uid;
    /**
     * Compliant with the following specification for EVSE ID from "eMI3 standard version V1.0"
     * (http://emi3group.com/documents-links/) "Part 2: business objects." Optional because: if an evse_id is
     * to be re-used in the real world, the evse_id can be removed from an EVSE object if the status is set to REMOVED.
     */
    @JsonProperty("evse_id")
    private String evseId;
    /**
     * Indicates the current status of the EVSE.
     */
    @JsonProperty("status")
    private Status status;
    /**
     * Indicates a planned status update of the EVSE.
     */
    @JsonProperty("status_schedule")
    private List<StatusSchedule> status_schedule;
    /**
     * List of functionalities that the EVSE is capable of.
     */
    @JsonProperty("capabilities")
    private List<Capability> capabilities;
    /**
     * List of available connectors on the EVSE.
     */
    @JsonProperty("connectors")
    private List<Connector> connectors;
    /**
     * Level on which the Charge Point is located (in garage buildings) in the
     * locally displayed numbering scheme.
     */
    @JsonProperty("floor_level")
    private String floorLevel;
    /**
     * Coordinates of the EVSE.
     */
    @JsonProperty("coordinates")
    private GeoLocation coordinates;
    /**
     * A number/string printed on the outside of the EVSE for visual
     * identification.
     */
    @JsonProperty("physical_reference")
    private String physicalReference;
    /**
     * Multi-language human-readable directions when more detailed information on how to reach the EVSE from
     * the Location is required.
     */
    @JsonProperty("directions")
    private List<DisplayText> directions;
    /**
     * The restrictions that apply to the parking spot.
     */
    @JsonProperty("parking_restrictions")
    private List<ParkingRestriction> parkingRestrictions;
    /**
     * Links to images related to the EVSE such as photos or logos.
     */
    @JsonProperty("images")
    private List<Image> images;
    /**
     * Timestamp when this EVSE or one of its Connectors was last updated (or created).
     */
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;

    public void setUid(String uid) {
        uidValidator.validate(uid);
        this.uid = uid;
    }

    public void setEvseId(String evseId) {
        evseIdValidator.validate(evseId);
        this.evseId = evseId;
    }

    public void setStatus(Status status) {
        requiredValidator.validate(status);
        this.status = status;
    }

    public void setStatus_schedule(List<StatusSchedule> status_schedule) {
        this.status_schedule = status_schedule;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public void setConnectors(List<Connector> connectors) {
        connectorsValidator.validate(connectors);
        this.connectors = connectors;
    }

    public void setFloorLevel(String floorLevel) {
        floorLevelValidator.validate(floorLevel);
        this.floorLevel = floorLevel;
    }

    public void setCoordinates(GeoLocation coordinates) {
        this.coordinates = coordinates;
    }

    public void setPhysicalReference(String physicalReference) {
        physicalReferenceValidator.validate(physicalReference);
        this.physicalReference = physicalReference;
    }

    public void setDirections(List<DisplayText> directions) {
        this.directions = directions;
    }

    public void setParkingRestrictions(List<ParkingRestriction> parkingRestrictions) {
        this.parkingRestrictions = parkingRestrictions;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        requiredValidator.validate(lastUpdated);
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean validate() {
        return uidValidator.safeValidate(uid)
                && requiredValidator.safeValidate(status)
                && connectorsValidator.safeValidate(connectors)
                && requiredValidator.safeValidate(lastUpdated)
                && connectors.stream().filter(Connector::validate).count() == connectors.size();
    }
}
