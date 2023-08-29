package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.enums.VersionNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionResponseDTO {
    @NotBlank
    public VersionNumber version;
    @NotBlank
    @Size(max = 255)
    public String url;
}
