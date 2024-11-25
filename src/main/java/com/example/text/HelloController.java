package com.example.text;

import com.example.text.services.FindMatch;
import com.example.text.utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    public Text matchedText;
    public Button undo;
    public Button redo;
    public ListView historyListView;
    public VBox historyPane;
    public Button toggleHistoryButton;
    public Button clearHistoryButton;
    // FXML components mapped to the FXML file
    @FXML private TextField regexField;
    @FXML private TextArea textArea, matchesArea, resultArea;
    @FXML private TextFlow matchesFlow;
    @FXML private TextField replaceField;


    private List<String> matchHistory = new ArrayList<>();

    private Deque<Replace> historyTrack = new ArrayDeque<>();
    UndoRedo undoRedo = new UndoRedo();

//    private Und



    // Method to find matches using the regex pattern
    @FXML
    public void findMatches1() {
        String regex = regexField.getText();
        String inputText = textArea.getText();


        if (regex.isEmpty() || inputText.isEmpty()) {

            matchesArea.setText("Please enter both a regex pattern and text.");
            return;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        StringBuilder matches = new StringBuilder();

        List <String> matchList = new ArrayList<>();

        while (matcher.find()) {
            // matches.append(matcher.group()).append("\n");
            matchList.add(matcher.group());
            matchList.remove("\n");
        }

        //matchesArea.setText(matches.toString());
        matchesArea.setText(String.join("\n", matchList));
    }

    public void findMatches() {

        String regex = regexField.getText();
        String inputText = textArea.getText();
        FindMatch findMatch = new FindMatch(regex, inputText);

        findMatch.matches(matchesFlow);

    }

    // Method to replace text using the regex pattern
    @FXML
    public void replaceText() {
        String regex = regexField.getText();
        String replacement = replaceField.getText();
        String inputText = textArea.getText();

        try{
            Replace replace = new Replace(regex, replacement);

            if (regex.isEmpty() || replacement.isEmpty() || inputText.isEmpty()) {
                resultArea.setText("Please fill in all fields.");
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Input Regex", "Please enter a valid regex.");
                return;
            }

            String result = inputText.replaceAll(regex, replacement);


            resultArea.setText(result);

            historyTrack.add(replace);

            undoRedo.performReplace(replace);

            System.out.println("rege " + undoRedo.getUndoStack().pop().getRegex() + " " + undoRedo.getUndoStack().pop().getRegex());

            // Store the replacement action in history
            matchHistory.add("Replaced '" + regex + "' with '" + replacement + "'");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Method to view unique matches
    @FXML
    public void viewUniqueMatches() {
        String matchesText = String.valueOf(matchesFlow.getChildren().get(0));

        matchesArea.getText();

        if (matchesText.isEmpty()) {
            resultArea.setText("No matches to display.");
            return;
        }

        String[] matches = matchesText.split("\n");
        List<String> uniqueMatches = new ArrayList<>();
        for (String match : matches) {
            if (!uniqueMatches.contains(match)) {
                uniqueMatches.add(match);
            }
        }

        resultArea.setText(String.join("\n", uniqueMatches));
    }

    // Method to view replacement history
    @FXML
    public void viewReplacementHistory() {
        if (matchHistory.isEmpty()) {
            resultArea.setText("No replacements performed yet.");
            return;
        }

        resultArea.setText(String.join("\n", matchHistory));
    }

    public void undoHandle(ActionEvent actionEvent) {
        try {
            if(undoRedo.undo() != null){
//                Pattern pattern = Pattern.compile(undoRedo.undo().getReplacement());
//                Matcher matcher = pattern.matcher(resultArea.getText());
//
//                String replaceResult = matcher.replaceAll(undoRedo.undo().getRegex());
//
//                resultArea.setText(replaceResult);



                System.out.println(undoRedo.undo().getRegex() + " " + undoRedo.undo().getReplacement());
            }
            System.out.println("noo");

//            System.out.println(resultArea.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void redoHandle(ActionEvent actionEvent) {



    }

    public void toggleHistory(ActionEvent actionEvent) {
    }
}
