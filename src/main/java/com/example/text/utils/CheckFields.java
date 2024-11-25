package com.example.text.utils;

import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CheckFields {
    public static boolean notEmptyFields(String regex, String inputText, TextFlow textFlow){
        if (regex.isEmpty() || inputText.isEmpty()) {
            textFlow.getChildren().clear();
            textFlow.getChildren().add(new Text("Please enter both a regex pattern and text."));
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Input Regex pattern", "Please enter both a regex pattern and text.");
            return true;
        }
        return false;
    }

}
