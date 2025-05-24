package org.example.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PomodoroController {
    @FXML
    Label title;
    @FXML
    Label timer;
    @FXML
    Label previous;
    @FXML
    Label current;
    @FXML
    Label next;
    @FXML
    Button completeTask;

    ObservableList<String> tasks;
    int currentIndex = 0;

    void setTasks(ObservableList<String> tasks) {
        this.tasks = tasks;
            }

    @FXML
    void initialize() {
        current.setText(tasks.get(currentIndex));
        next.setText(tasks.get(currentIndex + 1));
    }
}
