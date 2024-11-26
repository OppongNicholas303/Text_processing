package com.example.text.dataManagement;

import com.example.text.utils.PatternReplacement;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndoRedo {
    private static  final Deque<PatternReplacement> undoStack = new ArrayDeque<>(); ;
    private static final Deque<PatternReplacement> redoStack =  new ArrayDeque<>();




    public void performReplace(PatternReplacement patternReplacement){
        undoStack.push(patternReplacement);
    }

    public void clearStack(){
        undoStack.clear();
        redoStack.clear();
    }
    // getter
    public Deque<PatternReplacement> getUndoStack() {
        return undoStack;
    }

    public Deque<PatternReplacement> getRedoStack() {
        return redoStack;
    }


    public PatternReplacement undo(){
        PatternReplacement lastObject = null;
        if(!undoStack.isEmpty()) {
            lastObject= undoStack.pop();
            redoStack.push(lastObject); //move to redoStack
            return lastObject;
        }
        return lastObject;
    }

    public PatternReplacement redo(){
        PatternReplacement firstObject = null;
        if(!redoStack.isEmpty()) {
            firstObject = redoStack.pop();
            undoStack.push(firstObject); //move to undoStack
        }
        return firstObject;
    }


}
