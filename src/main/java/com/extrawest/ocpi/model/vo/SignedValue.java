package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.Validatable;
import com.extrawest.ocpi.validation.ValidationRules;
import com.extrawest.ocpi.validation.Validator;
import com.extrawest.ocpi.validation.ValidatorBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class contains the signed and the plain/unsigned data. By decoding the data, the receiver can check
 * if the content has not been altered.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SignedValue implements Validatable {

    @JsonIgnore
    private final Validator natureValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string32())
                    .build();

    @JsonIgnore
    private final Validator plainDataValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string512())
                    .build();

    @JsonIgnore
    private final Validator signedDataValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string5000())
                    .build();

    /**
     * Nature of the value, in other words, the event this value belongs to.
     * Possible values at moment of writing:
     * - Start (value at the start of the Session)
     * - End (signed value at the end of the Session)
     * - Intermediate (signed values take during the Session, after Start, before End)
     * Others might be added later.
     */
    @JsonProperty("nature")
    private String nature;

    /**
     * The un-encoded string of data. The format of the content depends on the EncodingMethod field.
     */
    @JsonProperty("plain_data")
    private String plainData;

    /**
     * Blob of signed data, base64 encoded. The format of the content depends on the EncodingMethod field.
     */
    @JsonProperty("signed_data")
    private String signedData;

    public void setNature(String nature) {
        natureValidator.validate(nature);
        this.nature = nature;
    }

    public void setPlainDat(String plainData) {
        plainDataValidator.validate(plainData);
        this.plainData = plainData;
    }

    public void setSignedData(String signedData) {
        signedDataValidator.validate(signedData);
        this.signedData = signedData;
    }

    @Override
    public boolean validate() {
        return natureValidator.safeValidate(nature)
                && plainDataValidator.safeValidate(plainData)
                && signedDataValidator.safeValidate(signedData);
    }
}
