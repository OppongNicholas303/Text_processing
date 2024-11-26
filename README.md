# Text Processing and Data Management Tool

## Overview

The **Text Processing and Data Management Tool** is a versatile Java application that allows users to perform powerful text manipulation and data management operations. With regular expressions (regex) for text search, match, and replace functionalities, coupled with efficient Java collections for data handling, this tool provides an interactive user experience through a JavaFX-based interface. 

Users can also track their text processing history, perform undo/redo actions, and manage their operations seamlessly.

---

## Features

### Regular Expressions (Regex) Module
- **Search, Match, and Replace**: Perform regex-based operations on text.
- **Supported Patterns**:
  - Sets (`[abc]`)
  - Ranges (`[a-z]`)
  - Alternations (`a|b`)
  - Short hands (`\d`, `\w`, etc.)
  - Quantifiers (`*`, `+`, `{n,m}`, etc.)
- **User-Friendly Interface**: Simplified input and application of regex patterns.

### Text Processing Module
- **Pattern Matching**: Search for regex patterns in input text.
- **Text Replacement**: Replace matched patterns with user-specified text.
- **History Management**:
  - Tracks all replacements using a **history** system.
  - **Undo/Redo** functionality implemented with `Deque`.
  - Clear history option to reset operations.
- **Feedback Display**: Real-time display of matches and processed text.

### Data Management Module
- **Java Collections**:
  - `HashSet`: Tracks unique user operations in history.
  - `Deque`: Implements undo/redo functionality for efficient user action management.
- **CRUD Operations**:
  - Create, update, and delete entries in data collections.
- **Custom Data Objects**:
  - Ensure collection integrity with proper `hashCode` and `equals` implementations.

### User Interface
- Built with **JavaFX** for an interactive experience.
- **Input Options**: Easily input text and regex patterns.
- **Result Display**: View match results, replaced text, and history in real-time.
- **Action Controls**: Perform undo, redo, replace, clear, and other operations effortlessly.

---

## Installation and Setup

### Prerequisites
- **Java Development Kit (JDK)** (version 8 or higher)
- **JavaFX** runtime environment

### Steps to Run
1. Clone or download the project from the repository.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure JavaFX libraries are properly configured in your project settings.
4. Build and run the project.

---

## Usage Guide

1. **Input Text and Regex**:
   - Enter the text you wish to process.
   - Specify a regex pattern for searching or replacing.

2. **Perform Operations**:
   - Use the **Search** button to find matches.
   - Use the **Replace** button to substitute matched patterns.

3. **Manage History**:
   - **Undo**: Revert the most recent change.
   - **Redo**: Reapply a reverted change.
   - **Clear History**: Reset all recorded actions.

4. **Explore Data**:
   - View and manage the history of replacements via the interface.
   - Ensure all changes are tracked uniquely with `HashSet`.

---

## Project Highlights

- **Undo/Redo with Deque**: Efficient action management for user convenience.
- **HashSet for History**: Fast and reliable tracking of unique operations.
- **Regex Powered by Pattern and Matcher**: Advanced text processing capabilities using Java's standard library.
- **JavaFX GUI**: Aesthetic and intuitive interface for seamless interaction.

