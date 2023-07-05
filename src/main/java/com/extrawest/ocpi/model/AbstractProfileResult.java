package com.extrawest.ocpi.model;

import com.extrawest.ocpi.model.enums.ChargingProfileResultType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractProfileResult {

    @JsonProperty("result")
    protected ChargingProfileResultType result;

    @JsonIgnore
    public String type;

    public String getType() {
        return this.getClass().getSimpleName();
    }

}
