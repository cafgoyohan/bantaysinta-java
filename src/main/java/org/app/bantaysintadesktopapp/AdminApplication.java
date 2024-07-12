package org.app.bantaysintadesktopapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminStart.fxml")));

        // Set the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("image/logo.png")));
        stage.getIcons().add(icon);

        // Create the scene
        Scene scene = new Scene(root, 900, 600);
        // Set the scene to the stage
        stage.setScene(scene);
        stage.setTitle("Bantay Sinta (Admin)"); // Set the window title

        stage.show(); // Show the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
