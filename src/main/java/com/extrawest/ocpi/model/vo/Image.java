package com.extrawest.ocpi.model.vo;

import com.extrawest.ocpi.model.enums.ImageCategory;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.extrawest.ocpi.validation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Image implements Validatable {

    @JsonIgnore
    private final Validator urlValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string255())
                    .build();
    @JsonIgnore
    private final Validator thumbnailValidator =
            new ValidatorBuilder()
                    .addRule(ValidationRules.string255())
                    .build();
    @JsonIgnore
    private final Validator typeValidator =
            new ValidatorBuilder()
                    .setRequired(true)
                    .addRule(ValidationRules.string4())
                    .build();
    @JsonIgnore
    private final Validator requiredValidator = new RequiredValidator();

    /**
     * URL from where the image data can be fetched through a web browser.
     */
    @JsonProperty("url")
    private String url;
    /**
     * URL from where a thumbnail of the image can be fetched through a
     * webbrowser.
     */
    @JsonProperty("thumbnail")
    private String thumbnail;
    /**
     * Describes what the image is used for.
     */
    @JsonProperty("category")
    private ImageCategory category;
    /**
     * Image type like: gif, jpeg, png, svg.
     */
    @JsonProperty("type")
    private String type;
    /**
     * Width of the full scale image.
     */
    @JsonProperty("width")
    private String width;
    /**
     * Height of the full scale image.
     */
    @JsonProperty("height")
    private String height;

    public void setUrl(String url) {
        urlValidator.validate(url);
        this.url = url;
    }

    public void setThumbnail(String thumbnail) {
        thumbnailValidator.validate(thumbnail);
        this.thumbnail = thumbnail;
    }

    public void setCategory(ImageCategory category) {
        requiredValidator.validate(category);
        this.category = category;
    }

    public void setType(String type) {
        typeValidator.validate(type);
        this.type = type;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public boolean validate() {
        return urlValidator.safeValidate(url)
                && requiredValidator.safeValidate(category)
                && typeValidator.safeValidate(type);
    }
}
