package com.extrawest.ocpi_emsp_prototype.dataTypes;

import com.extrawest.ocpi_emsp_prototype.validation.Validatable;
import com.extrawest.ocpi_emsp_prototype.validation.ValidationRules;
import com.extrawest.ocpi_emsp_prototype.validation.Validator;
import com.extrawest.ocpi_emsp_prototype.validation.ValidatorBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class DisplayText implements Validatable {

    private final transient Validator languageValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string2())
                    .build();
    private final transient Validator textValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string512())
                    .build();

    /**
     * Language Code ISO 639-1.
     */
    private String language;
    /**
     * Text to be displayed to a end user. No markup, html etc. allowed.
     */
    private String text;

    public void setLanguage(String language) {
        languageValidator.validate(language);
        this.language = language;
    }

    public void setText(String text) {
        textValidator.validate(text);
        this.text = text;
    }

    public DisplayText(String language, String text) {
        languageValidator.validate(language);
        textValidator.validate(text);
        this.language = language;
        this.text = text;
    }

    @Override
    public boolean validate() {
        return languageValidator.safeValidate(language)
                &&textValidator.safeValidate(text);
    }
}
