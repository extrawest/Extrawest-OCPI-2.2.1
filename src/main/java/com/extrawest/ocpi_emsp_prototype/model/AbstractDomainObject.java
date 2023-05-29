package com.extrawest.ocpi_emsp_prototype.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AbstractDomainObject {
    @JsonIgnore
    public transient String type;

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
