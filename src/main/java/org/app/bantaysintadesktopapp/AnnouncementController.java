package org.app.bantaysintadesktopapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class AnnouncementController
{
    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;
    public ImageView backButton;
    public ImageView annImage;
    public StackPane stackPane;

    public HBox annBox1; // Announcement box
    public HBox annBox2; // Announcement box
    public HBox annBox3; // Announcement box
    public HBox annBox4; // Announcement box

    @FXML
    public Label pageTime;
    public Label pageTitle;
    public Label pageBody;

    boolean inPage = false;

    public class Announcement
    {
        String time;
        String title;
        String body;
    }

    public void handleBackButtonClick(MouseEvent actionEvent) {
        if (inPage)
        {
            inPage = false;
            var page = stackPane.getChildren().getLast();
            page.setVisible(false);
        } else
        {
            navigateToReturnPage();
        }
    }

    @FXML
    private void handlePageClick(MouseEvent e)
    {
        inPage = true;
        var page = stackPane.getChildren().getLast();
        HBox annBox = (HBox) e.getSource();
        String id = annBox.getId();

        if (Objects.equals(id, "annBox1"))
        {
            pageTime.setText("Today");
            pageTitle.setText("Advisory");
            pageBody.setText("Please be advised that there will be NO FACE-TO-FACE and ONLINE (SYNCHRONOUS / ASYNCHRONOUS CLASSES) on January 9, 2024 in PUP Sta. Mesa Campus, following Malacañang Proclamation 434 declaring Tuesday, January 9, 2024, as a special non-working day in the City of Manila. Thank you.");
        } else if (Objects.equals(id, "annBox2"))
        {
            pageTime.setText("Jan 10");
            pageTitle.setText("Students and other stakeholders, WE NEED YOUR HELP.");
            pageBody.setText("The venerable University, via the Institute for Data and Statistical Analysis (IDSA), extends a gracious invitation for your esteemed presence in the Survey on the...");
        } else if (Objects.equals(id, "annBox3"))
        {
            pageTime.setText("Jan 4");
            pageTitle.setText("Advisory");
            pageBody.setText("Please be advised that there will be NO FACE-TO-FACE and ONLINE (SYNCHRONOUS / ASYNCHRONOUS CLASSES) on January 9, 2024 in PUP Sta. Mesa Campus, following Malacañang Proclamation 434 declaring Tuesday, January 9, 2024, as a special non-working day in the City of Manila. Thank you.");
        } else if (Objects.equals(id, "annBox4"))
        {
            pageTime.setText("Jan 4");
            pageTitle.setText("ATTENTION GRADUATING STUDENTS");
            pageBody.setText("Please be informed that the Application for Graduation for PUP Sta. Mesa and all Branches and Campuses will re-open on January 15, 2024.");
        }

        page.setVisible(true);
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
}
