package com.example;

import java.sql.*;
import java.util.Properties;

public class DatabaseUtils {
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        try (var input = DatabaseUtils.class.getClassLoader().getResourceAsStream("db.properties")) {
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load database properties", e);
        }

        String url = props.getProperty("db.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");
        return DriverManager.getConnection(url, username, password);
    }
}