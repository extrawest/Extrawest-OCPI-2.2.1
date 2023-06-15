package com.extrawest.ocpi.mapper;

import com.extrawest.ocpi.model.Token;
import com.extrawest.ocpi.model.dto.TokenDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TokenMapper {
    Token toTokenEntity(TokenDTO tokenDTO);
    TokenDTO toTokenDTO(Token token);
    List<TokenDTO> toListTokenDTO(List<Token> tokens);
    List<Token> toListToken(List<TokenDTO> tokenDTOS);
}
