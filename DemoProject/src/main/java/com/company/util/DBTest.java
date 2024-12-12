package com.company.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) {
        try {
            // Get connection using DBConnect class
            Connection connection = DBConnect.getConnection();
            
            if (connection != null) {
                System.out.println("Database connected successfully!");
                connection.close(); // Close the connection
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
