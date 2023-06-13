package com.extrawest.ocpi_emsp_prototype.model;

import com.extrawest.ocpi_emsp_prototype.model.enums.ChargingProfileResultType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractProfileResult {

    @JsonProperty("result")
    protected ChargingProfileResultType result;

    @JsonIgnore
    public transient String type;

    public String getType() {
        return this.getClass().getSimpleName();
    }

}
