package com.extrawest.ocpi_emsp_prototype.model.dto;

import com.extrawest.ocpi_emsp_prototype.model.vo.CredentialsRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDTO {
    private String token;
    private String url;
    private List<CredentialsRole> roles;
}
