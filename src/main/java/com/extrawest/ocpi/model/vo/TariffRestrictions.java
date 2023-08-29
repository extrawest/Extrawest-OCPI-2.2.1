package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.DayOfWeek;
import com.extrawest.ocpi.model.enums.ReservationRestrictionType;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.ValidationRules;
import com.extrawest.ocpi.validation.Validator;
import com.extrawest.ocpi.validation.ValidatorBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TariffRestrictions implements Validatable {

    @JsonIgnore
    private final Validator startTimeValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string5())
                    .build();

    @JsonIgnore
    private final Validator endTimeValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string5())
                    .build();

    @JsonIgnore
    private final Validator startDateValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string10())
                    .build();

    @JsonIgnore
    private final Validator endDateValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string10())
                    .build();

    /**
     * Start time of day in local time, the time zone is defined in the time_zone field of the Location,
     * for example 13:30, valid from this time of the day. Must be in 24h
     * format with leading zeros. Hour/Minute separator: ":" Regex: ([0-1][0-9]|2[0-3]):[0-5][0-9]
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * End time of day in local time, the time zone is defined in the time_zone field of the Location,
     * for example 19:45, valid until this time of the day. Same syntax as start_time.
     * If end_time < start_time then the period wraps around to the next day. To stop at end of the day use: 00:00.
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * Start date in local time, the time zone is defined in the time_zone field of the Location,
     * for example: 2015-12-24, valid from this day (inclusive).
     * Regex: ([12][0-9]{3})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * End date in local time, the time zone is defined in the time_zone field of the Location,
     * for example: 2015-12-27, valid until this day (exclusive). Same syntax as start_date.
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * Minimum consumed energy in kWh, for example 20, valid from this amount of energy (inclusive) being used.
     */
    @JsonProperty("min_kwh")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float minKwh;
    /**
     * Maximum consumed energy in kWh, for example 50, valid until this amount of energy (exclusive) being used.
     */
    @JsonProperty("max_kwh")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float maxKwh;
    /**
     * Sum of the minimum current (in Amperes) over all phases, for example 5. When the EV is charging with more than,
     * or equal to, the defined amount of current, this TariffElement is/becomes active.
     * If the charging current is or becomes lower, this TariffElement is not or no longer valid and becomes inactive.
     * This describes NOT the minimum current over the entire Charging Session.
     * This restriction can make a TariffElement become active when the charging current is above the defined value,
     * but the TariffElement MUST no longer be active when the charging current drops below the defined value.
     */
    @JsonProperty("min_current")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float minCurrent;
    /**
     * Sum of the maximum current (in Amperes) over all phases, for example 20.
     * When the EV is charging with less than the defined amount of current, this TariffElement becomes/is active.
     * If the charging current is or becomes higher, this TariffElement is not or no longer valid and becomes inactive.
     * This describes NOT the maximum current over the entire Charging Session. This restriction can make a TariffElement
     * become active when the charging current is below this value, but the TariffElement MUST no longer be active when
     * the charging current raises above the defined value
     */
    @JsonProperty("max_current")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float maxCurrent;
    /**
     * Minimum power in kW, for example 5. When the EV is charging with more than, or equal to, the defined amount of power,
     * this TariffElement is/becomes active. If the charging power is or becomes lower,
     * this TariffElement is not or no longer valid and becomes inactive. This describes NOT the minimum power over the
     * entire Charging Session. This restriction can make a TariffElement become active when the charging power is
     * above this value, but the TariffElement MUST no longer be active when the charging power drops below the defined value.
     */
    @JsonProperty("min_power")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float minPower;
    /**
     * Maximum power in kW, for example 20. When the EV is charging with less than the defined amount of power,
     * this TariffElement becomes/is active. If the charging power is or becomes higher, this TariffElement is not
     * or no longer valid and becomes inactive. This describes NOT the maximum power over the entire Charging Session.
     * This restriction can make a TariffElement become active when the charging power is below this value,
     * but the TariffElement MUST no longer be active when the charging power raises above the defined value
     */
    @JsonProperty("max_power")
    @Digits(integer = Integer.MAX_VALUE, fraction = 4)
    private Float maxPower;
    /**
     * Minimum duration in seconds the Charging Session MUST last (inclusive). When the duration of a Charging Session
     * is longer than the defined value, this TariffElement is or becomes active. Before that moment,
     * this TariffElement is not yet active.
     */
    @JsonProperty("min_duration")
    private Integer minDuration;
    /**
     * Maximum duration in seconds the Charging Session MUST last (exclusive). When the duration of a Charging Session
     * is shorter than the defined value, this TariffElement is or becomes active. After that moment,
     * this TariffElement is no longer active.
     */
    @JsonProperty("max_duration")
    private Integer maxDuration;
    /**
     * Which day(s) of the week this TariffElement is active
     */
    @JsonProperty("day_of_week")
    private List<DayOfWeek> dayOfWeek;
    /**
     * When this field is present, the TariffElement describes reservation costs. A reservation starts when
     * the reservation is made, and ends when the driver starts charging on the reserved EVSE/Location, or when
     * the reservation expires. A reservation can only have: FLAT and TIME TariffDimensions, where TIME is for the
     * duration of the reservation.
     */
    private ReservationRestrictionType reservation;

    public void setStart_time(String startTime) {
        startTimeValidator.validate(startTime);
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        endTimeValidator.validate(endTime);
        this.endTime = endTime;
    }

    public void setStartDate(String startDate) {
        startDateValidator.validate(startDate);
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        endDateValidator.validate(endDate);
        this.endDate = endDate;
    }

    public void setMinKwh(Float minKwh) {
        this.minKwh = minKwh;
    }

    public void setMaxKwh(Float maxKwh) {
        this.maxKwh = maxKwh;
    }

    public void setMinCurrent(Float minCurrent) {
        this.minCurrent = minCurrent;
    }

    public void setMaxCurrent(Float maxCurrent) {
        this.maxCurrent = maxCurrent;
    }

    public void setMinPower(Float minPower) {
        this.minPower = minPower;
    }

    public void setMaxPower(Float maxPower) {
        this.maxPower = maxPower;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setDayOfWeek(List<DayOfWeek> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setReservation(ReservationRestrictionType reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
