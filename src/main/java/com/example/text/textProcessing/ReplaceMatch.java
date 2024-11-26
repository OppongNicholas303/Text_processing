package com.example.text.textProcessing;

import com.example.text.utils.AlertHelper;
import com.example.text.utils.PatternReplace;
import com.example.text.utils.PatternReplacement;
import com.example.text.dataManagement.UndoRedo;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class ReplaceMatch {
    private String regex;
    private String replacement;
    private String inputText;
    private TextArea resultArea;
    private UndoRedo undoRedo;

    public ReplaceMatch(String regex, String replacement, String inputText, TextArea resultArea, UndoRedo undoRedo) {
        this.regex = regex;
        this.replacement = replacement;
        this.inputText = inputText;
        this.resultArea = resultArea;
        this.undoRedo = undoRedo;
    }

    public void replaceText() {
            PatternReplacement patternReplacement = new PatternReplacement(regex, replacement);

            if (regex.isEmpty() || replacement.isEmpty() || inputText.isEmpty()) {
                resultArea.setText("Please fill in all fields.");
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Input Regex", "Please enter a valid regex.");
                return;
            }

            PatternReplace patternReplace  = new PatternReplace();
            resultArea.setText(patternReplace.patternForReplace(regex, replacement, inputText));
            undoRedo.performReplace(patternReplacement);
        }
}
