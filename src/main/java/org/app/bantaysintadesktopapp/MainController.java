package org.app.bantaysintadesktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainController {

    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;

    @FXML
    private Text greetingText;

    @FXML
    private Text dateText;

    private String username;

    // Method to set the username
    public void setUsername(String username) {
        this.username = username;
        initialize(); // Call initialize to update greetingText immediately
    }

    @FXML
    public void initialize() {
        // Set greeting message with user's first name
        if (username != null && !username.isEmpty()) {
            greetingText.setText("Hello, " + username);
        } else {
            greetingText.setText("Hello, Guest");
        }

        // Set current date
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM, yyyy");
        dateText.setText(formatter.format(currentDate));
    }

    @FXML
    private void handleAnnouncements(ActionEvent event) {
        // Handle Announcements button click
        navigateToAnnouncementsPage();
    }

    @FXML
    private void handleReportOccurrence(ActionEvent event) {
        // Handle Report an Occurrence button click
        navigateToReportPage();
    }

    @FXML
    private void handleEmergencyProtocols(ActionEvent event) {
        // Handle Emergency Protocols button click
    }

    @FXML
    private void handleCampusMap(ActionEvent event) {
        // Handle Campus Map button click
    }

    @FXML
    private void handleHomeClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(homeIcon); // Change size of the clicked icon
        System.out.println("Home icon clicked");
    }

    @FXML
    private void handleReportClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(reportIcon); // Change size of the clicked icon
        navigateToReportPage(); // Navigate to Report page
        System.out.println("Report icon clicked");
    }

    @FXML
    private void handleMapClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(mapIcon); // Change size of the clicked icon
        navigateToCampusMapPage(); // Navigate to Campus Map page
        System.out.println("Map icon clicked");
    }

    @FXML
    private void handleProfileClick(MouseEvent event) {
        resetIconSize(); // Reset size of all icons
        changeIconSize(profileIcon); // Change size of the clicked icon
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

    private void navigateToReportPage() {
        try {
            // Close the main stage
            Stage mainStage = (Stage) greetingText.getScene().getWindow();
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

    private void navigateToCampusMapPage() {
        try {
            // Close the main stage
            Stage mainStage = (Stage) greetingText.getScene().getWindow();
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

    private void navigateToAnnouncementsPage()
    {
        try {
            // Close the main stage
            Stage mainStage = (Stage) greetingText.getScene().getWindow();
            mainStage.close();

            // Load ReportPage.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Announcement.fxml"));
            Parent root = loader.load();

            // Create and show the report page stage
            Stage reportStage = new Stage();
            reportStage.setScene(new Scene(root));
            reportStage.setTitle("Announcements");
            reportStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
