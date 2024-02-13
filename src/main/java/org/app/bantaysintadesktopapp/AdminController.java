package org.app.bantaysintadesktopapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.VBox;

public class AdminController
{
    public ImageView homeIcon;
    public ImageView reportIcon;
    public ImageView mapIcon;
    public ImageView profileIcon;
    public ImageView backButton;
    public StackPane stackPane;

    public VBox reportBoxContainer;
    public FlowPane reportBox;

    public Label pageTime;
    public Label pageSubject;
    public Label pageLocation;
    public Label pageBody;
    public ImageView pageImage;

    List<Report> reports = new ArrayList<>();

    boolean inReport = false;

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/bantay_sinta_db";
    private final String USERNAME = "root";
    private final String PASSWORD = "rootpass";

    public class Report
    {
        public String Time = "Today";
        public String Subject = "Subject";
        public String Location = "Location";
        public String Body = "Body";
        public String ImagePath = "@image/no_image.png";
    }

    public void handleBackButtonClick(MouseEvent actionEvent) {
        if (inReport)
        {
            inReport = false;
            var page = stackPane.getChildren().getLast();
            page.setVisible(false);
        }
    }

    @FXML
    public void initialize() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bantay_sinta_db.reports");

            while (resultSet.next())
            {
                Report report = new Report();
                // report.Time = resultSet.getString(); Wala pang nagsesave nito
                report.Subject = resultSet.getString(2);
                report.Location = resultSet.getString(3);
                report.Body = resultSet.getString(4);
                report.ImagePath = resultSet.getString(5);
                reports.add(report);
            }

            int i = 0;
            for (Report report : reports)
            {
                //System.out.print(report);
                FlowPane flowPane = createFlowPane(report, i);
                reportBoxContainer.getChildren().add(flowPane);
                i++;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private FlowPane createFlowPane(Report data, int index)
    {
        FlowPane flowPane = new FlowPane();

        flowPane.setPrefWidth(645);
        flowPane.setPrefHeight(102);
        flowPane.getStyleClass().addAll("report-box");
        flowPane.setOnMouseClicked(event -> {

            System.out.println("FlowPane clicked at index: " + index);
            inReport = true;
            var page = stackPane.getChildren().getLast();

            Report clickedReport = reports.get(index);
            pageTime.setText(clickedReport.Time);
            pageSubject.setText(clickedReport.Subject);
            pageLocation.setText(clickedReport.Location);
            pageBody.setText(clickedReport.Body);
//            pageImage.setText();

            page.setVisible(true);
        });

        // Customize the FlowPane with data
        Label todayLabel = new Label("Today");

        Label subjectLabel = new Label(data.Subject);
        subjectLabel.getStyleClass().addAll("report-box-label-subject");

        Label locationLabel = new Label(data.Location);
        locationLabel.getStyleClass().addAll("report-box-label-location");

        Label bodyLabel = new Label(data.Body);
        bodyLabel.getStyleClass().addAll("report-box-label-body");

        VBox vbox = new VBox();
        vbox.getStyleClass().addAll("report-box-body-cont");
        vbox.getChildren().addAll(subjectLabel, locationLabel, bodyLabel);

//        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(data.ImagePath)));
//        imageView.setFitWidth(75);
//        imageView.setFitHeight(75);
        flowPane.getChildren().addAll(todayLabel, vbox);

        return flowPane;
    }
}
