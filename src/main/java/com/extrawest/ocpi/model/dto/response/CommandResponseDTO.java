package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.enums.CommandResponseType;
import com.extrawest.ocpi.model.vo.DisplayText;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandResponseDTO {
    @NotBlank
    private CommandResponseType result;
    @NotBlank
    private Integer timeout;
    private List<DisplayText> message;
}
