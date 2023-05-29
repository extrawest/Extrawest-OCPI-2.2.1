package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.enums.VersionNumber;
import com.extrawest.ocpi_emsp_prototype.model.vo.Endpoint;
import lombok.Data;

import java.util.List;

@Data
public class VersionDetailsResponseDTO {
    private VersionNumber version;
    private List<Endpoint> endpoints;
}
