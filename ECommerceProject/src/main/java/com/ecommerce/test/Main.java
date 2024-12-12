package com.ecommerce.test;

import com.ecommerce.util.DBConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Get database connection
        Connection connection = DBConnection.getConnection();

        // If connection is not null, print success
        if (connection != null) {
            System.out.println("Connection test successful!");
        } else {
            System.out.println("Connection test failed.");
        }
    }
}
