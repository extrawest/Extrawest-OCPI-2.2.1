package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.Token;
import com.extrawest.ocpi_emsp_prototype.model.enums.AllowedType;
import com.extrawest.ocpi_emsp_prototype.model.vo.DisplayText;
import com.extrawest.ocpi_emsp_prototype.model.vo.LocationReferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationInfoResponseDTO {
    @JsonProperty("allowed")
    private AllowedType allowed;
    @JsonProperty("token")
    private Token token;
    @JsonProperty("location")
    private LocationReferences location;
    @JsonProperty("authorization_reference")
    private String authorizationReference;
    @JsonProperty("info")
    private DisplayText info;
}
