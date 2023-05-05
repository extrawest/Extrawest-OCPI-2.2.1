package com.extrawest.ocpi_emsp_prototype.validation;

public class ValidationRules {

    public static IValidationRule string2() {
        return new StringMaxLengthValidationRule(2);
    }

    public static IValidationRule string3() {
        return new StringMaxLengthValidationRule(3);
    }

    public static IValidationRule string5() {
            return new StringMaxLengthValidationRule(5);
    }

    public static IValidationRule string10() {
        return new StringMaxLengthValidationRule(10);
    }

    public static IValidationRule string36() {
        return new StringMaxLengthValidationRule(36);
    }

    public static IValidationRule string64() {
        return new StringMaxLengthValidationRule(64);
    }

    public static IValidationRule string512() {
        return new StringMaxLengthValidationRule(512);
    }
}
