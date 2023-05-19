package com.extrawest.ocpi_emsp_prototype.dataTypes;

import com.extrawest.ocpi_emsp_prototype.dataTypes.enums.TokenType;
import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PublishTokenType implements Validatable {

    /**
     * Unique ID by which this Token can be identified.
     */
    @JsonProperty("uid")
    private String uid;
    /**
     * Type of the token.
     */
    @JsonProperty("type")
    private TokenType type;
    /**
     * Visual readable number/identification as printed on the Token (RFID card).
     */
    @JsonProperty("visual_number")
    private String visualNumber;
    /**
     * Issuing company, most of the times the name of the company printed on the token (RFID card),
     * not necessarily the eMSP
     */
    @JsonProperty("issuer")
    private String issuer;
    /**
     * This ID groups a couple of tokens. This can be used to make two or more tokens work as one.
     */
    @JsonProperty("group_id")
    private String groupId;

    @Override
    public boolean validate() {
        return true;
    }
}
