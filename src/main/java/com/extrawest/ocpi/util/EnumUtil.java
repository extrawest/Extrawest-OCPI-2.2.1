package com.extrawest.ocpi.util;

import java.util.function.Function;

public final class EnumUtil {

    private EnumUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static <T extends Enum<T>> T findByField(Class<T> enumType,
                                                    Function<T, String> fieldSelector,
                                                    String fieldValue) {
        for (T enumValue : enumType.getEnumConstants()) {
            if (fieldSelector.apply(enumValue).equals(fieldValue)) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException(String.format(
                "No enum constant %s with field value %s", enumType.getName(), fieldValue
        ));
    }

}
