package com.extrawest.ocpi.model.enums;

import com.extrawest.ocpi.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The category of an image to obtain the correct usage in a user presentation. The category has
 * to be set accordingly to the image content in order to guarantee the right usage.
 */
public enum ImageCategory {
    /**
     * Photo of the physical device that contains one or more EVSEs.
     */
    CHARGER("CHARGER"),
    /**
     * Location entrance photo. Should show the car entrance to the location from street side.
     */
    ENTRANCE("ENTRANCE"),
    /**
     * Location overview photo.
     */
    LOCATION("LOCATION"),
    /**
     * Logo of an associated roaming network to be displayed with the EVSE for example in lists, maps
     * and detailed information views.
     */
    NETWORK("NETWORK"),
    /**
     * Logo of an associated roaming network to be displayed with the EVSE for example in lists, maps
     * and detailed information views.
     */
    OPERATOR("OPERATOR"),
    /**
     * Other
     */
    OTHER("OTHER"),
    /**
     * Logo of the charge point owner, for example a local store, to be displayed in the EVSEs detailed
     * information view
     */
    OWNER("OWNER");
    private final String value;

    ImageCategory(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static ImageCategory fromValue(String value) {
        return EnumUtil.findByField(
                ImageCategory.class,
                ImageCategory::value,
                value
        );
    }
}
