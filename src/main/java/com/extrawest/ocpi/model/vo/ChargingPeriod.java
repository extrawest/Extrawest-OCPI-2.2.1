package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.ListOfAtLeastOneObjects;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * A Charging Period consists of a start timestamp and a list of possible values that influence this period,
 * for example: amount of energy charged this period, maximum current during this period etc.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ChargingPeriod implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    @JsonIgnore
    private final Validator dimensionsValidator = new ListOfAtLeastOneObjects();

    /**
     * Start timestamp of the charging period. A period ends when the next period starts.
     * The last period ends when the session ends.
     */
    @JsonProperty("start_date_time")
    private LocalDateTime startDateTime;

    /**
     * List of relevant values for this charging period.
     */
    @JsonProperty("dimensions")
    private List<CdrDimension> dimensions;

    /**
     * Unique identifier of the Tariff that is relevant for this Charging Period. If not provided,
     * no Tariff is relevant during this period.
     */
    @JsonProperty("tariff_id")
    private String tariffId;

    public void setStartDateTime(LocalDateTime startDateTime) {
        requiredValidator.validate(startDateTime);
        this.startDateTime = startDateTime;
    }

    public void setDimensions(List<CdrDimension> dimensions) {
        dimensionsValidator.validate(dimensions);
        this.dimensions = dimensions;
    }

    public void setTariffId(String tariffId) {
        this.tariffId = tariffId;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(startDateTime)
                && dimensionsValidator.safeValidate(dimensions);
    }
}
