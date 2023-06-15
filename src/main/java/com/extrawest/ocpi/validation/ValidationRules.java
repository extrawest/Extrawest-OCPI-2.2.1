package com.extrawest.ocpi.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationRules {

    public static IValidationRule string1() {
        return new StringMaxLengthValidationRule(1);
    }

    public static IValidationRule string2() {
        return new StringMaxLengthValidationRule(2);
    }

    public static IValidationRule string3() {
        return new StringMaxLengthValidationRule(3);
    }

    public static IValidationRule string4() {
        return new StringMaxLengthValidationRule(4);
    }

    public static IValidationRule string5() {
            return new StringMaxLengthValidationRule(5);
    }

    public static IValidationRule string10() {
        return new StringMaxLengthValidationRule(10);
    }

    public static IValidationRule string11() {
        return new StringMaxLengthValidationRule(11);
    }

    public static IValidationRule string16() {
        return new StringMaxLengthValidationRule(16);
    }

    public static IValidationRule string20() {
        return new StringMaxLengthValidationRule(20);
    }

    public static IValidationRule string32() {
        return new StringMaxLengthValidationRule(32);
    }

    public static IValidationRule string36() {
        return new StringMaxLengthValidationRule(36);

    }

    public static IValidationRule string39() {
        return new StringMaxLengthValidationRule(39);
    }

    public static IValidationRule string45() {
        return new StringMaxLengthValidationRule(45);
    }

    public static IValidationRule string48() {
        return new StringMaxLengthValidationRule(48);
    }

    public static IValidationRule string255() {
        return new StringMaxLengthValidationRule(255);
    }

    public static IValidationRule string64() {
        return new StringMaxLengthValidationRule(64);
    }

    public static IValidationRule string512() {
        return new StringMaxLengthValidationRule(512);
    }
    public static IValidationRule string5000() {
        return new StringMaxLengthValidationRule(5000);
    }
}
