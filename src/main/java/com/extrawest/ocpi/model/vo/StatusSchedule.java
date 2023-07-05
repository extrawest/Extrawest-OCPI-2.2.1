package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.Status;
import com.extrawest.ocpi.validation.RequiredValidator;
import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.Validator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

/**
 * This type is used to schedule status periods in the future. The eMSP can provide this information to the EV user
 * for trip planning purposes. A period MAY have no end. Example: "This station will be running as of tomorrow.
 * Today it is still planned and under construction."
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class StatusSchedule implements Validatable {

    @JsonIgnore
    private final Validator<Object> requiredValidator = new RequiredValidator();

    /**
     * Begin of the scheduled period.
     */
    private LocalDateTime period_begin;
    /**
     * End of the scheduled period, if known.
     */
    private LocalDateTime period_end;
    /**
     * Status value during the scheduled period.
     */
    private Status status;

    public void setPeriod_begin(LocalDateTime period_begin) {
        requiredValidator.validate(period_begin);
        this.period_begin = period_begin;
    }

    public void setPeriod_end(LocalDateTime period_end) {
        this.period_end = period_end;
    }

    public void setStatus(Status status) {
        requiredValidator.validate(status);
        this.status = status;
    }

    @Override
    public boolean validate() {
        return requiredValidator.safeValidate(period_begin)
                && requiredValidator.safeValidate(status);
    }
}
