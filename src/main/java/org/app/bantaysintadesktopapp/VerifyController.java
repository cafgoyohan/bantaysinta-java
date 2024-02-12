package org.app.bantaysintadesktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class VerifyController {

    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bantay_sinta_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootpass";

    // SQL statement to insert data into the database
    private static final String INSERT_SQL = "INSERT INTO reports (subject, location, description, file_name, image_path, certification, student_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;
    public ImageView backButton;
    public Label subjectLabel;
    public Label locationLabel;
    public Label descriptionLabel;

    @FXML
    private ImageView imageView;
    @FXML
    private TextField imagePathField;
    @FXML
    private Label fileNameLabel;
    @FXML
    private Text greetingText;

    @FXML
    private CheckBox certificationCheckbox;

    @FXML
    private void handleBackButtonClick(MouseEvent actionEvent) {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Report.fxml"));
            Parent root = loader.load();

            // Create and show the main page stage
            Stage mainStage = new Stage();
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Report Page");
            mainStage.show();

            // Close the current stage (Report.fxml)
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleSubmitButtonClick(ActionEvent event) {
        // Check if the checkbox is selected
        if (certificationCheckbox.isSelected()) {
            // Perform submission
            System.out.println("Submission successful.");

            // Prompt the user to provide the image path
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Student Number");
            dialog.setHeaderText(null);
            dialog.setContentText("Please enter your student number for verification:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(studentNum -> {
                // Insert the report into the database
                insertReportIntoDatabase(studentNum);
            });

            navigateToSuccessPage(event);

        } else {
            // Show an alert or message indicating the checkbox must be checked
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please certify that the details provided are true and legitimate.");
            alert.showAndWait();
        }
    }

    private void navigateToSuccessPage(ActionEvent event) {
        try {
            // Load Main.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Success.fxml"));
            Parent root = loader.load();

            // Create and show the main page stage
            Stage mainStage = new Stage();
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Thank you for submitting a report!");
            mainStage.show();

            // Close the current stage (Report.fxml)
            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertReportIntoDatabase(String studentNum) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bantay_sinta_db";
        String username = "root";
        String password = "rootpass";

        // SQL query to insert report
        String sql = "INSERT INTO reports (subject, location, description, file_name, image_path, certification, student_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                // Establish database connection
                Connection connection = DriverManager.getConnection(url, username, password);
                // Create prepared statement
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            // Set parameters for the prepared statement
            statement.setString(1, subjectLabel.getText());
            statement.setString(2, locationLabel.getText());
            statement.setString(3, descriptionLabel.getText());
            statement.setString(4, fileNameLabel.getText());
            statement.setString(5, imagePathField.getText());
            statement.setBoolean(6, true);
            statement.setString(7, studentNum);

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Report inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayDetails(String subject, String location, String description, Image image, String fileName, String imagePath) {
        // Display the received details
        subjectLabel.setText(subject);
        locationLabel.setText(location);
        descriptionLabel.setText(description);
        imageView.setImage(image);
        fileNameLabel.setText(fileName); // Assuming fileNameLabel is a Label
        imagePathField.setText(imagePath); // Assuming imagePathField is a TextField
    }

}
