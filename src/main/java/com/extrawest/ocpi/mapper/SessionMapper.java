package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.Session;
import com.extrawest.ocpi.model.dto.SessionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionMapper {
    SessionDTO toSessionDTO (Session session);
    Session toSessionEntity (SessionDTO sessionDTO);
}
