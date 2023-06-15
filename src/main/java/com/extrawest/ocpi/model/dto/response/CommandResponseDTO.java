package com.extrawest.ocpi.model.dto.response;

import com.extrawest.ocpi.model.enums.CommandResponseType;
import com.extrawest.ocpi.model.vo.DisplayText;
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
