package org.app.bantaysintadesktopapp;

import java.sql.*;

public class UserService {

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bantay_sinta_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootpass";

    // Method to retrieve the student number directly
    public String getStudentNumber(String studentNumber) {
        String foundStudentNumber = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT student_number FROM users WHERE student_number = ?");
        ) {
            statement.setString(1, studentNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                foundStudentNumber = resultSet.getString("student_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundStudentNumber;
    }
}

