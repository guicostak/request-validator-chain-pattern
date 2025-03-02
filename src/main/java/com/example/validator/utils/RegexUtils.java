package com.example.validator.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexUtils {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public boolean isEmailValid(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }
}
