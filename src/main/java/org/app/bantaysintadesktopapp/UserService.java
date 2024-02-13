package org.app.bantaysintadesktopapp;

import java.sql.*;

public class UserService {

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bantay_sinta_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    // Method to retrieve the user's profile from the database
    public UserProfile getUserProfile(String studentNumber) {
        UserProfile userProfile = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT u.*, p.* FROM users u JOIN profiles p " +
                     "ON u.user_id = p.user_id WHERE u.student_number = ?");
        ) {
            statement.setString(1, studentNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String program = resultSet.getString("program");
                String year = resultSet.getString("year");
                String section = resultSet.getString("section");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                userProfile = new UserProfile(firstName, lastName, studentNumber, program, year, section, email, address);
            } else {
                System.out.println("No profile found for student number: " + studentNumber);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving user profile: " + e.getMessage());
            e.printStackTrace();
        }
        return userProfile;
    }
}
