package org.example.controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TaskController {
    @FXML
    TextField taskInput;
    @FXML
    ListView<String> taskList;
    @FXML
    Button startButton;

    ObservableList<String> tasks = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        taskList.setItems(tasks);
        taskInput.setOnAction(event -> {
            if (taskInput.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Empty Task Error");
                alert.setContentText("Please enter a non empty task name.");
                alert.showAndWait();
            } else {
                tasks.add(taskInput.getText());
                taskInput.clear();
            }
        });
    }
}
