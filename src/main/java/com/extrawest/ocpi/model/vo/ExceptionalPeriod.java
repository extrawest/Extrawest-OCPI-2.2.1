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

import java.time.LocalDateTime;

/**
 * Specifies one exceptional period for opening or access hours.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ExceptionalPeriod implements Validatable {

    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * Begin of the exception. In UTC, time_zone field can be used to convert to local time.
     */
    @JsonProperty("period_begin")
    private LocalDateTime periodBegin;
    /**
     * End of the exception. In UTC, time_zone field can be used to convert to local time.
     */
    @JsonProperty("period_end")
    private LocalDateTime periodEnd;

    public void setPeriodBegin(LocalDateTime periodBegin) {
        requiredValidator.validate(periodBegin);
        this.periodBegin = periodBegin;
    }

    public void setPeriodEnd(LocalDateTime periodEnd) {
        requiredValidator.validate(periodEnd);
        this.periodEnd = periodEnd;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(periodBegin)
                && requiredValidator.safeValidate(periodEnd);
    }
}
