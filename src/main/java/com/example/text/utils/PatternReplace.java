package com.example.text.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternReplace {

    public String patternForReplace (String regex, String replacement, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(replacement);
    }
}
