package org.example.controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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

        startButton.setOnAction(event -> {
            // Send data to next controller
            PomodoroController pomodoroController = new PomodoroController();
            pomodoroController.setTasks(tasks);

            Scene scene = null;

            try {
                // Load scene in try catch in case fxml is not available
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/PomodoroScreen.fxml"));
                loader.setController(pomodoroController);

                Parent root = loader.load();
                scene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage = (Stage) (
                    ((Node) event.getSource())
                            .getScene()
                            .getWindow());

            stage.setTitle("Pomodoro For Java");
            stage.setScene(scene);
            stage.show();
        });
    }
}
