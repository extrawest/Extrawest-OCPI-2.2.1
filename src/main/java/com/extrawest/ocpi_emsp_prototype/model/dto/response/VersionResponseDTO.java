package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.enums.VersionNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionResponseDTO {
    public VersionNumber version;
    public String url;
}
