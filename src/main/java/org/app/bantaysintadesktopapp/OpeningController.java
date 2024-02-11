package org.app.bantaysintadesktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OpeningController implements Initializable {
    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void openSignInPage(ActionEvent event) throws IOException {
        // Load the SignInPage.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Signin.fxml"));
        Parent signInPageParent = loader.load();

        // Get the opening page's scene dimensions
        Scene openingScene = rootPane.getScene();
        double openingWidth = openingScene.getWidth();
        double openingHeight = openingScene.getHeight();

        // Create the sign-in page scene with the same dimensions
        Scene signInPageScene = new Scene(signInPageParent, openingWidth, openingHeight);

        // Get the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        window.setScene(signInPageScene);
        window.show();
    }

}


