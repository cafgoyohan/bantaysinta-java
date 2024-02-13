package org.app.bantaysintadesktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminStartController
{
    public TextField emailField;
    public PasswordField passwordField;
    public Label errorMessageLabel;

    private final String DB_URL = "jdbc:mysql://localhost:3306/bantay_sinta_db";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "123456";

    public void signInAction(ActionEvent event)
    {
        String email = emailField.getText();
        String password = passwordField.getText();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT u.*, p.first_name FROM users u JOIN profiles p ON u.user_id = p.user_id " +
                    "WHERE u.email = ? AND u.student_number = ? AND u.password = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(3, password);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Successful login
                        String firstName = resultSet.getString("first_name");
                        System.out.println("Login successful for user: " + firstName);

                        // Get the FXMLLoader and load the Main.fxml file
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
                        Parent root = loader.load();

                        // Get the MainController instance
                        MainController mainController = loader.getController();

                        // Set the username in the MainController
                        mainController.setUsername(firstName);

                        // Show the Main.fxml scene
                        Scene scene = new Scene(root, 900, 600);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Bantay Sinta (Admin)");
                        stage.show();
                    } else {
                        // Invalid credentials
                        System.out.println("Invalid credentials");
                        // Show error message
                        errorMessageLabel.setText("Invalid credentials. Please try again.");
                        errorMessageLabel.setVisible(true);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}
