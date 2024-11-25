package com.example.text.services;

import com.example.text.utils.AlertHelper;
import com.example.text.utils.CheckFields;
import com.example.text.utils.RegexValidation;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindMatch {
    private String regex;
    private String inputText;

    public FindMatch(String regex, String inputText) {
        this.regex = regex;
        this.inputText = inputText;
    }

    public  void matches(TextFlow matchesFlow){
        try {


            if (!RegexValidation.isValidEmail(regex)) AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Input Regex", "Please enter a valid regex.");

            if(CheckFields.notEmptyFields(regex, inputText, matchesFlow)) return;

            matchesFlow.getChildren().clear();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputText);

            int lastIndex = 0;

            while (matcher.find()) {
                matchesFlow.getChildren().add(new Text(inputText.substring(lastIndex, matcher.start())));

                Text textToHighlight = new Text(matcher.group());

                textToHighlight.setStyle("-fx-font-weight: bold; -fx-fill: blue;");

                matchesFlow.getChildren().add(textToHighlight);

                matchesFlow.getChildren().add(new Text(inputText.substring(matcher.end(), inputText.length())));

                lastIndex = matcher.end();
            }
        } catch (Exception e) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
            e.printStackTrace();
            matchesFlow.getChildren().add( new Text("Not found"));
        }
    }
}
