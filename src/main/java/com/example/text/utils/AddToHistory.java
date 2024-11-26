package com.example.text.utils;

import java.util.ArrayList;
import java.util.List;

public class AddToHistory {
    private String regex;
    private String replacement;

    public AddToHistory(String regex, String replacement) {
        this.regex = regex;
        this.replacement = replacement;
    }

    public List<String> getHistory(List<String> history) {
        history.add("Replaced '" + regex + "' with '" + replacement + "'");
        return history;
    }
}
