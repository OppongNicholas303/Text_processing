package com.example.text.utils;

public class Replace {
    private String regex;
    private String replacement;

    public Replace(String regex, String replacement) {
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
