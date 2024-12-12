package com.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Returns a connection to the MySQL database
    public static Connection getConnection() {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection URL for MySQL
            String url = "jdbc:mysql://localhost:3306/ecommerce_system";  // Ensure the database name is correct
            String user = "root";  // MySQL username
            String password = "root";  // MySQL password

            // Create and return connection
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;  // Return null if connection fails
        }
    }
}
