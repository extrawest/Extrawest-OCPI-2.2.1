package com.extrawest.ocpi_emsp_prototype.dataTypes;

import com.extrawest.ocpi_emsp_prototype.dataTypes.enums.DayOfWeek;
import com.extrawest.ocpi_emsp_prototype.dataTypes.enums.ReservationRestrictionType;
import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.ValidationRules;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.extrawest.ocpi_emsp_prototype.validation.ValidatorBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TariffRestrictions implements Validatable {

    private final transient Validator start_timeValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string5())
                    .build();

    private final transient Validator end_timeValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string5())
                    .build();

    private final transient Validator start_dateValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string10())
                    .build();

    private final transient Validator end_dateValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string10())
                    .build();

    /**
     * Start time of day in local time, the time zone is defined in the time_zone field of the Location,
     * for example 13:30, valid from this time of the day. Must be in 24h
     * format with leading zeros. Hour/Minute separator: ":" Regex: ([0-1][0-9]|2[0-3]):[0-5][0-9]
     */
    private String start_time;
    /**
     * End time of day in local time, the time zone is defined in the time_zone field of the Location,
     * for example 19:45, valid until this time of the day. Same syntax as start_time.
     * If end_time < start_time then the period wraps around to the next day. To stop at end of the day use: 00:00.
     */
    private String end_time;
    /**
     * Start date in local time, the time zone is defined in the time_zone field of the Location,
     * for example: 2015-12-24, valid from this day (inclusive).
     * Regex: ([12][0-9]{3})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])
     */
    private String start_date;
    /**
     * End date in local time, the time zone is defined in the time_zone field of the Location,
     * for example: 2015-12-27, valid until this day (exclusive). Same syntax as start_date.
     */
    private String end_date;
    /**
     * Minimum consumed energy in kWh, for example 20, valid from this amount of energy (inclusive) being used.
     */
    private Float min_kwh;
    /**
     * Maximum consumed energy in kWh, for example 50, valid until this amount of energy (exclusive) being used.
     */
    private Float max_kwh;
    /**
     * Sum of the minimum current (in Amperes) over all phases, for example 5. When the EV is charging with more than,
     * or equal to, the defined amount of current, this TariffElement is/becomes active.
     * If the charging current is or becomes lower, this TariffElement is not or no longer valid and becomes inactive.
     * This describes NOT the minimum current over the entire Charging Session.
     * This restriction can make a TariffElement become active when the charging current is above the defined value,
     * but the TariffElement MUST no longer be active when the charging current drops below the defined value.
     */
    private Float min_current;
    /**
     * Sum of the maximum current (in Amperes) over all phases, for example 20.
     * When the EV is charging with less than the defined amount of current, this TariffElement becomes/is active.
     * If the charging current is or becomes higher, this TariffElement is not or no longer valid and becomes inactive.
     * This describes NOT the maximum current over the entire Charging Session. This restriction can make a TariffElement
     * become active when the charging current is below this value, but the TariffElement MUST no longer be active when
     * the charging current raises above the defined value
     */
    private Float max_current;
    /**
     * Minimum power in kW, for example 5. When the EV is charging with more than, or equal to, the defined amount of power,
     * this TariffElement is/becomes active. If the charging power is or becomes lower,
     * this TariffElement is not or no longer valid and becomes inactive. This describes NOT the minimum power over the
     * entire Charging Session. This restriction can make a TariffElement become active when the charging power is
     * above this value, but the TariffElement MUST no longer be active when the charging power drops below the defined value.
     */
    private Float min_power;
    /**
     * Maximum power in kW, for example 20. When the EV is charging with less than the defined amount of power,
     * this TariffElement becomes/is active. If the charging power is or becomes higher, this TariffElement is not
     * or no longer valid and becomes inactive. This describes NOT the maximum power over the entire Charging Session.
     * This restriction can make a TariffElement become active when the charging power is below this value,
     * but the TariffElement MUST no longer be active when the charging power raises above the defined value
     */
    private Float max_power;
    /**
     * Minimum duration in seconds the Charging Session MUST last (inclusive). When the duration of a Charging Session
     * is longer than the defined value, this TariffElement is or becomes active. Before that moment,
     * this TariffElement is not yet active.
     */
    private Integer min_duration;
    /**
     * Maximum duration in seconds the Charging Session MUST last (exclusive). When the duration of a Charging Session
     * is shorter than the defined value, this TariffElement is or becomes active. After that moment,
     * this TariffElement is no longer active.
     */
    private Integer max_duration;
    /**
     * Which day(s) of the week this TariffElement is active
     */
    private List<DayOfWeek> day_of_week;
    /**
     * When this field is present, the TariffElement describes reservation costs. A reservation starts when
     * the reservation is made, and ends when the driver starts charging on the reserved EVSE/Location, or when
     * the reservation expires. A reservation can only have: FLAT and TIME TariffDimensions, where TIME is for the
     * duration of the reservation.
     */
    private ReservationRestrictionType reservation;

    public void setStart_time(String start_time) {
        start_timeValidator.validate(start_time);
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        end_timeValidator.validate(end_time);
        this.end_time = end_time;
    }

    public void setStart_date(String start_date) {
        start_dateValidator.validate(start_date);
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        end_dateValidator.validate(end_date);
        this.end_date = end_date;
    }

    public void setMin_kwh(Float min_kwh) {
        this.min_kwh = min_kwh;
    }

    public void setMax_kwh(Float max_kwh) {
        this.max_kwh = max_kwh;
    }

    public void setMin_current(Float min_current) {
        this.min_current = min_current;
    }

    public void setMax_current(Float max_current) {
        this.max_current = max_current;
    }

    public void setMin_power(Float min_power) {
        this.min_power = min_power;
    }

    public void setMax_power(Float max_power) {
        this.max_power = max_power;
    }

    public void setMin_duration(Integer min_duration) {
        this.min_duration = min_duration;
    }

    public void setMax_duration(Integer max_duration) {
        this.max_duration = max_duration;
    }

    public void setDay_of_week(List<DayOfWeek> day_of_week) {
        this.day_of_week = day_of_week;
    }

    public void setReservation(ReservationRestrictionType reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
