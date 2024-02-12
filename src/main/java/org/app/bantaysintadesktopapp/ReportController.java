package org.app.bantaysintadesktopapp;

import com.sun.javafx.charts.Legend;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ReportController
{

    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;
    public ImageView backButton;
    public TextField subjectField;
    public TextField locationField;
    public TextField descriptionField;

    @FXML
    private ImageView imageView;
    @FXML
    private TextField imagePathField;
    @FXML
    private Label fileNameLabel;
    @FXML
    private Text greetingText;

    public void handleBackButtonClick(MouseEvent actionEvent) {
        navigateToReturnPage();
    }

    @FXML
    private void handleHomeClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(homeIcon); // Change size of the clicked icon
        navigateToReturnPage();
        System.out.println("Home icon clicked");
    }

    @FXML
    private void handleReportClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(reportIcon); // Change size of the clicked icon
        System.out.println("Report icon clicked");
    }

    @FXML
    private void handleMapClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(mapIcon); // Change size of the clicked icon
        navigateToCampusMapPage();
        System.out.println("Map icon clicked");
    }

    @FXML
    private void handleProfileClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(profileIcon); // Change size of the clicked icon
        navigateToProfilePage();
        System.out.println("Profile icon clicked");
    }

    private void changeIconSize(ImageView icon) {
        // Change size of the clicked icon
        double CLICKED_SIZE = 35.0; // Size when clicked
        icon.setFitWidth(CLICKED_SIZE);
        icon.setFitHeight(CLICKED_SIZE);
    }

    private void resetIconSize() {
        // Reset size of all icons to original size
        double ORIGINAL_SIZE = 30.0;  // Original size of the icons
        homeIcon.setFitWidth(ORIGINAL_SIZE);
        homeIcon.setFitHeight(ORIGINAL_SIZE);
        reportIcon.setFitWidth(ORIGINAL_SIZE);
        reportIcon.setFitHeight(ORIGINAL_SIZE);
        mapIcon.setFitWidth(ORIGINAL_SIZE);
        mapIcon.setFitHeight(ORIGINAL_SIZE);
        profileIcon.setFitWidth(ORIGINAL_SIZE);
        profileIcon.setFitHeight(ORIGINAL_SIZE);
    }

    private void navigateToReturnPage() {
        try {
            // Load Main.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root = loader.load();

            // Create and show the main page stage
            Stage mainStage = new Stage();
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Main Page");
            mainStage.show();

            // Close the current stage (Report.fxml)
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleNextButtonClick(ActionEvent actionEvent) {
        // Validate if all required fields are filled
        if (subjectField.getText().isEmpty() || locationField.getText().isEmpty() ||
                descriptionField.getText().isEmpty() || imageView.getImage() == null ||
                fileNameLabel.getText().isEmpty() || imagePathField.getText().isEmpty()) {

            // Show an alert or message indicating that all fields are required
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all fields before proceeding.");
            alert.showAndWait();
            return; // Exit method without proceeding
        }

        try {
            // Load Verify.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Verify.fxml"));
            Parent root = loader.load();

            // Get the controller of the Verify page
            VerifyController verifyController = loader.getController();

            // Pass the entered details to the Verify page
            verifyController.displayDetails(subjectField.getText(), locationField.getText(),
                    descriptionField.getText(), imageView.getImage(), fileNameLabel.getText(), imagePathField.getText());

            // Create and show the Verify page stage
            Stage verifyStage = new Stage();
            verifyStage.setScene(new Scene(root));
            verifyStage.setTitle("Verify Details");
            verifyStage.show();

            // Close the current stage (Report.fxml)
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Method to handle image selection
    @FXML
    private void handleImportImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());

        if (selectedFile != null) {
            try {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);

                // Display the file name
                fileNameLabel.setText(selectedFile.getName());

                // Set the image path to the text field
                imagePathField.setText(selectedFile.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void navigateToProfilePage() {
        try {
            // Close the main stage
            Stage mainStage = (Stage) profileIcon.getScene().getWindow();
            mainStage.close();

            // Load ReportPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root = loader.load();

            // Create and show the report page stage
            Stage reportStage = new Stage();
            reportStage.setScene(new Scene(root));
            reportStage.setTitle("Profile Page");
            reportStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void navigateToCampusMapPage() {
        try {
            // Close the main stage
            Stage mainStage = (Stage) mapIcon.getScene().getWindow();
            mainStage.close();

            // Load ReportPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CampusMap.fxml"));
            Parent root = loader.load();

            // Create and show the report page stage
            Stage reportStage = new Stage();
            reportStage.setScene(new Scene(root));
            reportStage.setTitle("Campus Map");
            reportStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
