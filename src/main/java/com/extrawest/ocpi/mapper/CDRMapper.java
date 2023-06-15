package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.CDR;
import com.extrawest.ocpi.model.dto.CdrDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CDRMapper {
    CDR toCdrEntity(CdrDTO cdrDTO);
    CdrDTO toCdrDTO(CDR cdr);
}
