package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Opening and access hours of the location.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Hours implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * True to represent 24 hours a day and 7 days a week, except the given exceptions.
     */
    @JsonProperty("twentyfourseven")
    private Boolean twentyFourSeven;
    /**
     * Regular hours, weekday-based. Only to be used if twentyfourseven=false, then this field needs to contain at least
     * one RegularHours object.
     */
    @JsonProperty("regular_hours")
    private List<RegularHours> regularHours;
    /**
     * Exceptions for specified calendar dates, time-range based. Periods the station is operating/accessible.
     * Additional to regular_hours. May overlap regular rules.
     */
    @JsonProperty("exceptional_openings")
    private List<ExceptionalPeriod> exceptionalOpenings;
    /**
     * Exceptions for specified calendar dates, time-range based. Periods the station is not operating/accessible.
     * Overwriting regular_hours and exceptional_openings. Should not overlap exceptional_openings.
     */
    @JsonProperty("exceptional_closings")
    private List<ExceptionalPeriod> exceptionalClosings;

    public void setTwentyFourSeven(Boolean twentyFourSeven) {
        requiredValidator.validate(twentyFourSeven);
        this.twentyFourSeven = twentyFourSeven;
    }

    public void setRegularHours(List<RegularHours> regularHours) {
        this.regularHours = regularHours;
    }

    public void setExceptionalOpenings(List<ExceptionalPeriod> exceptionalOpenings) {
        this.exceptionalOpenings = exceptionalOpenings;
    }

    public void setExceptionalClosings(List<ExceptionalPeriod> exceptionalClosings) {
        this.exceptionalClosings = exceptionalClosings;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(twentyFourSeven);
    }
}
