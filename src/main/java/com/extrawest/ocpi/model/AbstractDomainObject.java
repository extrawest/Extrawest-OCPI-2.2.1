package com.extrawest.ocpi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractDomainObject {
    @JsonIgnore
    public transient String type;

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
