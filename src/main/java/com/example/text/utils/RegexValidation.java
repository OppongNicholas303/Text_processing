package com.example.text.utils;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexValidation {
    public static boolean isValidEmail(String regex) {
        try {
            Pattern.compile(regex);
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
