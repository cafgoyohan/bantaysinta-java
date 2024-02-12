package org.app.bantaysintadesktopapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CampusMapController
{
    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;
    public ImageView backButton;
    public ImageView campusMapImage;
    public ImageView fullMapImage;
    public StackPane stackPane;
    public ScrollPane spMain;
    public ScrollPane spFullMap;
    public Group groupFullMap;
    double maxZoom = 16.0;
    double minZoom = 0.0;
    int zoomLevel = 8;
    boolean fullMapVisible = false;

    public void handleBackButtonClick(MouseEvent actionEvent) {
        if (fullMapVisible)
        {
            fullMapVisible = false;
            var image = stackPane.getChildren().getLast();
            image.setVisible(false);
        } else
        {
            navigateToReturnPage();
        }
    }

    @FXML
    private void handleHomeClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(homeIcon); // Change size of the clicked icon
        navigateToMainPage();
        System.out.println("Home icon clicked");
    }

    @FXML
    private void handleReportClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(reportIcon); // Change size of the clicked icon
        navigateToReportPage();
        System.out.println("Report icon clicked");
    }

    @FXML
    private void handleMapClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(mapIcon); // Change size of the clicked icon
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

    public void handleCampusMapClick(MouseEvent actionEvent) {
        fullMapVisible = true;
        var image = stackPane.getChildren().getLast();
        image.setVisible(true);
    }

    public void handleFullMapClick(MouseEvent e)
    {
        double oldScaleX = fullMapImage.getScaleX();
        double oldScaleY = fullMapImage.getScaleY();

        if (e.getButton() == MouseButton.PRIMARY && zoomLevel < maxZoom) {
            fullMapImage.setScaleX(oldScaleX * 1.2);
            fullMapImage.setScaleY(oldScaleY * 1.2);
            zoomLevel++;
        } else if (e.getButton() == MouseButton.SECONDARY && zoomLevel > minZoom) {
            fullMapImage.setScaleX(oldScaleX / 1.2);
            fullMapImage.setScaleY(oldScaleY / 1.2);
            zoomLevel--;
        }
    }

    private void navigateToReportPage() {
        try {
            // Close the main stage
            Stage mainStage = (Stage) reportIcon.getScene().getWindow();
            mainStage.close();

            // Load ReportPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Report.fxml"));
            Parent root = loader.load();

            // Create and show the report page stage
            Stage reportStage = new Stage();
            reportStage.setScene(new Scene(root));
            reportStage.setTitle("Report Page");
            reportStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void navigateToMainPage() {
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
            Stage currentStage = (Stage) homeIcon.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
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
}
