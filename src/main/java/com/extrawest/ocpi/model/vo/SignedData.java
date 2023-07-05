package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * This class contains all the information of the signed data. Which encoding method is used, if needed,
 * the public key and a list of signed values.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SignedData implements Validatable {

    @JsonIgnore
    private final Validator encodingMethodValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string36())
                    .build();

    @JsonIgnore
    private final Validator signedValuesValidator = new ListOfAtLeastOneObjects();

    @JsonIgnore
    private final Validator urlValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string512())
                    .build();

    /**
     * The name of the encoding used in the SignedData field. This is the name given to the encoding by a company
     * or group of companies. See note below.
     */
    @JsonProperty("encoding_method")
    private String encodingMethod;

    /**
     * Version of the EncodingMethod (when applicable)
     */
    @JsonProperty("encoding_method_version")
    private Integer encodingMethodVersion;

    /**
     * Public key used to sign the data, base64 encoded.
     */
    @JsonProperty("public_key")
    private String publicKey;

    /**
     * One or more signed values
     */
    @JsonProperty("signed_values")
    private List<SignedValue> signedValues;

    /**
     * URL that can be shown to an EV driver. This URL gives the EV driver the possibility to check
     * the signed data from a charging session.
     */
    @JsonProperty("url")
    private String url;

    public void setEncodingMethod(String encodingMethod) {
        encodingMethodValidator.validate(encodingMethod);
        this.encodingMethod = encodingMethod;
    }

    public void setEncodingMethodVersion(Integer encodingMethodVersion) {
        this.encodingMethodVersion = encodingMethodVersion;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setSignedValues(List<SignedValue> signedValues) {
        signedValuesValidator.validate(signedValues);
        this.signedValues = signedValues;
    }

    public void setUrl(String url) {
        urlValidator.validate(url);
        this.url = url;
    }

    @Override
    public boolean validate() {
        return encodingMethodValidator.safeValidate(encodingMethod)
                && signedValuesValidator.safeValidate(signedValues);
    }
}
