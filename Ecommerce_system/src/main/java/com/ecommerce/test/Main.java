package com.ecommerce.test;

import com.ecommerce.utils.DBConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Test connection
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            System.out.println("Database connected successfully!");
        } else {
            System.out.println("Database connection failed.");
        }
    }
}
