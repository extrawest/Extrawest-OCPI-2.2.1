package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.enums.VersionNumber;
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
