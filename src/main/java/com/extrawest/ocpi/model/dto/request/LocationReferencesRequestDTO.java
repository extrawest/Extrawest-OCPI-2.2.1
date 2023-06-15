package com.extrawest.ocpi.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationReferencesRequestDTO {
    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("evse_uids")
    private List<String> evseUids;
}
