package com.example.text.textProcessing;

import com.example.text.utils.AlertHelper;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindMatch {
    private String regex;
    private String inputText;

    public FindMatch(String regex, String inputText) {
        this.regex = regex;
        this.inputText = inputText;
    }

    public void matches(TextArea textArea) {
        try {
            StringBuilder highlightedText = new StringBuilder();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputText);

            int lastIndex = 0;

            while (matcher.find()) {
                // Append text before the match
                highlightedText.append(inputText.substring(lastIndex, matcher.start()));

                // Append the matched text wrapped with markers (e.g., **)
                highlightedText.append("**").append(matcher.group()).append("**");

                // Update the last index
                lastIndex = matcher.end();
            }

            // Append remaining text
            highlightedText.append(inputText.substring(lastIndex));

            // Set the reconstructed text back to the TextArea
            textArea.setText(highlightedText.toString());

        } catch (Exception e) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
            e.printStackTrace();
        }
    }

}
