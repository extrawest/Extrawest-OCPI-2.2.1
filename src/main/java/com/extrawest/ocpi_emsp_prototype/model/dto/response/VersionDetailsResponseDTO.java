package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.enums.VersionNumber;
import com.extrawest.ocpi_emsp_prototype.model.vo.Endpoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionDetailsResponseDTO {
    private VersionNumber version;
    private List<Endpoint> endpoints;
}
