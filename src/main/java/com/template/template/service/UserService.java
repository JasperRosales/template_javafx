package com.template.template.service;

import com.template.template.config.DatabaseSetup;
import com.template.template.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void addUser(User user) {
        String query = "INSERT INTO test (fullname, age) VALUES (?, ?)";

        try (Connection connection = DatabaseSetup.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public User getUserFromName(String searchName) {
        String query = "SELECT fullname, age FROM test WHERE fullname = ?";

        try (Connection connection = DatabaseSetup.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, searchName);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getString("fullname"),
                            rs.getInt("age")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error fetching user: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
