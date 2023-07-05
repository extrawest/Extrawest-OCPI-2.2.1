package com.extrawest.ocpi.model.dto.request;

import com.extrawest.ocpi.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationReferencesRequestDTO {
    @NotBlank
    @Size(min = 1, max = 36)
    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("evse_uids")
    private List<@Size(min = 1, max=36) @Pattern(regexp = Constants.ASCII_REGEXP) String> evseUids;
}
