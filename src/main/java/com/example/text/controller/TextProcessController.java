package com.example.text.controller;

import com.example.text.dataManagement.UndoRedo;
import com.example.text.textProcessing.FindMatch;
import com.example.text.textProcessing.ReplaceMatch;
import com.example.text.utils.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;

import java.util.*;

public class TextProcessController {

    public ListView historyListView;

    @FXML private TextField regexField;
    @FXML private TextArea textArea, matchesArea, resultArea;
    @FXML private TextFlow matchesFlow;
    @FXML private TextField replaceField;


//    private List<String> matchHistory = new ArrayList<>();
    private final HashSet<String> matchHistory = new HashSet<>();

//    private Deque<PatternReplacement> historyTrack = new ArrayDeque<>();

    UndoRedo undoRedo = new UndoRedo();

    public void initialize() {
        viewReplacementHistory();
    }

    public void viewReplacementHistory() {
        // Convert the ArrayList to an ObservableList
        ObservableList<String> observableHistory = FXCollections.observableArrayList(matchHistory);

        // Set the ObservableList to the ListView
        historyListView.setItems(observableHistory);
    }


    // Method to find matches using the regex pattern
    @FXML
    public void findMatches() {

        String regex = regexField.getText();
        String inputText = textArea.getText();
        FindMatch findMatch = new FindMatch(regex, inputText);

        findMatch.matches( resultArea);

    }

    // Method to replace text using the regex pattern
    @FXML
    public void replaceText() {
        String regex = regexField.getText();
        String replacement = replaceField.getText();
        String inputText = textArea.getText();

        try{
            ReplaceMatch replaceMatch = new ReplaceMatch(
                    regex,
                    replacement,
                    inputText,
                    resultArea,
                    undoRedo
            );

            replaceMatch.replaceText();

            // Store the replacement action in history
            matchHistory.add("Replaced '" + regex + "' with '" + replacement + "'");

            // Update the ListView (UI update) if you're using ListView for history
            ObservableList<String> observableHistory = FXCollections.observableArrayList(matchHistory);
            historyListView.setItems(observableHistory);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void undoHandle(ActionEvent actionEvent) {
            if(!undoRedo.getUndoStack().isEmpty()){
                PatternReplacement patternReplacement = undoRedo.undo();

               if(patternReplacement != null){
                   String regex = patternReplacement.getRegex();
                   String inputText = textArea.getText();
                   String replacement = patternReplacement.getReplacement();

                   PatternReplace undoText = new PatternReplace();
                   resultArea.setText(undoText.patternForReplace(regex, replacement, inputText));
               }

            }else {
                resultArea.setText(textArea.getText());
            }
    }

    public void redoAction(ActionEvent actionEvent) {
        if (!undoRedo.getRedoStack().isEmpty()) {
            PatternReplacement patternReplacement = undoRedo.redo();

            if (patternReplacement != null) {
                String regex = patternReplacement.getRegex();
                String inputText = textArea.getText();
                String replacement = patternReplacement.getReplacement();

                PatternReplace redoText = new PatternReplace();

                resultArea.setText(redoText.patternForReplace(regex, replacement, inputText));
            }
        } else {
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, "stack Empty", " The stack is empty" );

        }
    }

    public void clearAll(ActionEvent actionEvent) {
        textArea.clear();
        resultArea.clear();
        undoRedo.clearStack();
        matchHistory.clear();

        // Update the ListView (UI update) if you're using ListView for history
        ObservableList<String> observableHistory = FXCollections.observableArrayList(matchHistory);
        historyListView.setItems(observableHistory);

    }

}
