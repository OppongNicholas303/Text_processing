package com.example.text.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndoRedo {
    private final Deque<Replace> undoStack = new ArrayDeque<>(); ;
    private final Deque<Replace> redoStack =  new ArrayDeque<>();


    public Deque<Replace> getUndoStack() {
        return undoStack;
    }

    public Deque<Replace> getRedoStack() {
        return redoStack;
    }

    public void performReplace(Replace replace){
        undoStack.push(replace);
    }


    public Replace  undo(){
        Replace lastObject = null;
        if(!undoStack.isEmpty()) {
            lastObject= undoStack.pop();
            redoStack.push(lastObject); //move to redoStack
            return lastObject;
        }
        return lastObject;
    }

    public Replace redo(){
        Replace lastObject = null;
        if(!undoStack.isEmpty()) {
            lastObject= redoStack.pop();
            undoStack.push(lastObject); //move to undoStack
        }
        return lastObject;
    }


}
