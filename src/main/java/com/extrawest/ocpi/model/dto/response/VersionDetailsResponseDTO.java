package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.enums.VersionNumber;
import com.extrawest.ocpi.model.vo.Endpoint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionDetailsResponseDTO {
    @NotBlank
    private VersionNumber version;
    @NotBlank
    private List<Endpoint> endpoints;
}
