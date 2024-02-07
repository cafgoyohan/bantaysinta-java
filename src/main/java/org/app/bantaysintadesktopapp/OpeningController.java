package org.app.bantaysintadesktopapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class OpeningController implements Initializable {
    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load background image
        URL imageUrl = getClass().getResource("/img/opening.png");
        if (imageUrl != null) {
            Image backgroundImage = new Image(imageUrl.toExternalForm());

            // Set background properties
            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT
            );

            // Apply background to StackPane
            rootPane.setBackground(new Background(background));
        } else {
            System.err.println("Error: Background image not found!");
        }
    }

}
