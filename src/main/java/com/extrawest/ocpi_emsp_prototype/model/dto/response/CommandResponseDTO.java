package com.extrawest.ocpi_emsp_prototype.model.dto.response;

import com.extrawest.ocpi_emsp_prototype.model.enums.CommandResponseType;
import com.extrawest.ocpi_emsp_prototype.model.vo.DisplayText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandResponseDTO {
    private CommandResponseType result;
    private Integer timeout;
    private List<DisplayText> message;
}
