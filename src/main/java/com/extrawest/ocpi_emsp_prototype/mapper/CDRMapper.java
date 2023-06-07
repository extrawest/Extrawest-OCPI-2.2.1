package com.extrawest.ocpi_emsp_prototype.mapper;

import com.extrawest.ocpi_emsp_prototype.model.CDR;
import com.extrawest.ocpi_emsp_prototype.model.dto.CdrDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CDRMapper {
    CDR toCdrEntity(CdrDTO cdrDTO);
    CdrDTO toCdrDTO(CDR cdr);
}
