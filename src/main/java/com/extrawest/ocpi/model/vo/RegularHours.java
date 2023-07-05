package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.ValidationRules;
import com.extrawest.ocpi.validation.Validator;
import com.extrawest.ocpi.validation.ValidatorBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Regular recurring operation or access hours.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RegularHours implements Validatable {

    @JsonIgnore
    private final Validator weekdayValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string1())
                    .build();
    @JsonIgnore
    private final Validator periodValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string5())
                    .build();

    /**
     * Number of day in the week, from Monday (1) till Sunday (7)
     */
    @JsonProperty("weekday")
    private Integer weekday;
    /**
     * Begin of the regular period, in local time, given in hours and minutes. Must be in 24h format with leading zeros.
     * Example: "18:15". Hour/Minute separator: ":" Regex: ([0-1][0-9]|2[0-3]):[0-5][0-9].
     */
    @JsonProperty("period_begin")
    private String periodBegin;
    /**
     * End of the regular period, in local time, syntax as for period_begin. Must be later than period_begin.
     */
    @JsonProperty("period_end")
    private String periodEnd;

    public void setWeekday(Integer weekday) {
        weekdayValidator.validate(String.valueOf(weekday));
        this.weekday = weekday;
    }

    public void setPeriodBegin(String periodBegin) {
        periodValidator.validate(periodBegin);
        this.periodBegin = periodBegin;
    }

    public void setPeriodEnd(String periodEnd) {
        periodValidator.validate(periodEnd);
        this.periodEnd = periodEnd;
    }

    @Override
    public boolean validate() {
        return weekdayValidator.safeValidate(String.valueOf(weekday))
                && periodValidator.safeValidate(periodBegin)
                && periodValidator.safeValidate(periodEnd);
    }
}
