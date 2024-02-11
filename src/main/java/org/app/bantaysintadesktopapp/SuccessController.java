package org.app.bantaysintadesktopapp;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SuccessController{
    public BorderPane borderPane;
    public ImageView backButton;
    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;

    public void openMainPage(ActionEvent actionEvent) {
        try {
            // Load Main.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root = loader.load();

            // Create and show the main page stage
            Stage mainStage = new Stage();
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Main Page");
            mainStage.show();

            // Close the current stage (Success.fxml)
            Stage currentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    private void handleReportClick(MouseEvent mouseEvent) {
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

    private void navigateToReportPage() {
        try {
            // Load Main.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Report.fxml"));
            Parent root = loader.load();

            // Create and show the main page stage
            Stage mainStage = new Stage();
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Report Page");
            mainStage.show();

            // Close the current stage (Report.fxml)
            Stage currentStage = (Stage) reportIcon.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


