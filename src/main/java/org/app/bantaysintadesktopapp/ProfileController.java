package org.app.bantaysintadesktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;
    @FXML
    private Text userNameText;
    @FXML
    private Text studentNumberText;
    @FXML
    private Text programText;
    @FXML
    private Text yearSectionText;
    @FXML
    private Text addressText;
    @FXML
    private Text emailText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Fetch user profile details from the database
        UserService userService = new UserService();
        UserProfile userProfile = userService.getUserProfile("2021-12345-MN-0");

        // Display user profile details in the UI
        if (userProfile != null) {
            userNameText.setText(userProfile.getFirstName() + " " + userProfile.getLastName());
            studentNumberText.setText(userProfile.getStudentNumber());
            programText.setText(userProfile.getProgram());
            yearSectionText.setText(userProfile.getYear() + " - " + userProfile.getSection());
            addressText.setText(userProfile.getAddress());
            emailText.setText(userProfile.getEmail());
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
        navigateToReportPage(); // Navigate to Report page
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
        System.out.println("Profile icon clicked");
    }


    public void handleLogOutButtonClick(ActionEvent event) {
        navigateToOpeningPage(event);
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

    private void navigateToOpeningPage(ActionEvent event) {
        try {
            // Load Opening.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OpeningPage.fxml"));
            Parent root = loader.load();

            // Create and show the opening page stage
            Stage openingPageStage = new Stage();
            openingPageStage.setScene(new Scene(root));
            openingPageStage.setTitle("Opening Page");
            openingPageStage.show();

            // Close the current stage (Profile.fxml)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
