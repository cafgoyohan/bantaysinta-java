package org.app.bantaysintadesktopapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/app/bantaysintadesktopapp/OpeningPage.fxml")));
        Scene scene = new Scene(root, 360, 640);
        stage.setScene(scene);
        stage.setTitle("Bantay Sinta");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}