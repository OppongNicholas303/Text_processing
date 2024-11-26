package com.example.text.utils;

public class PatternReplacement {
    private String regex;
    private String replacement;

    public PatternReplacement(String regex, String replacement) {
        this.regex = regex;
        this.replacement = replacement;
    }

    public String getReplacement() {
        return replacement;
    }

    public String getRegex() {
        return regex;
    }
}
