package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file for the main layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/MainLayout.fxml"));
        Parent root = loader.load();  // Load the root element from the FXML

        // Create a scene with the loaded layout and apply the stylesheet
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/org/example/styles.css").toExternalForm());

        // Set the title of the primary stage (main window)
        primaryStage.setTitle("Simple File Manager");
        primaryStage.setScene(scene);  // Set the scene for the stage
        primaryStage.show();  // Show the stage
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}


