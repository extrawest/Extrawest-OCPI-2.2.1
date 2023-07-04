package com.extrawest.ocpi.model.dto;

import com.extrawest.ocpi.model.vo.CredentialsRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDTO {
    @Size(min = 1, max = 64)
    @NotBlank
    private String token;
    @NotBlank
    @Size(max = 255)
    private String url;
    @NotBlank
    private List<CredentialsRole> roles;
}
