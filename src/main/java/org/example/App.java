package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/TaskScreen.fxml"));
            scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Pomodoro For Java");
        stage.setScene(scene);
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}