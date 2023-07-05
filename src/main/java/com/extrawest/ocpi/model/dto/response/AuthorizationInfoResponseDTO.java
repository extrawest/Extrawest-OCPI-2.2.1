package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.Token;
import com.extrawest.ocpi.model.enums.AllowedType;
import com.extrawest.ocpi.model.vo.DisplayText;
import com.extrawest.ocpi.model.vo.LocationReferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationInfoResponseDTO {
    @NotBlank
    @JsonProperty("allowed")
    private AllowedType allowed;
    @NotBlank
    @JsonProperty("token")
    private Token token;
    @JsonProperty("location")
    private LocationReferences location;
    @Size(min = 1, max = 36)
    @JsonProperty("authorization_reference")
    private String authorizationReference;
    @JsonProperty("info")
    private DisplayText info;
}
