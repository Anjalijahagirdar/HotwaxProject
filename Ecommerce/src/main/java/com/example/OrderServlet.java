package com.example;

import org.json.JSONObject;  // Import org.json package for JSON handling
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read parameters from the HTTP request
        String orderDate = request.getParameter("orderDate");
        String customerId = request.getParameter("customerId");
        String shippingContactId = request.getParameter("shippingContactMechId");
        String billingContactId = request.getParameter("billingContactMechId");

        // Prepare the response object (using JSONObject from org.json)
        JSONObject jsonResponse = new JSONObject();

        // Check for missing parameters
        if (orderDate == null || customerId == null || shippingContactId == null || billingContactId == null) {
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "Missing required parameters");
        } else {
            // Database connection and insert logic
            try (Connection conn = DatabaseUtils.getConnection();
                 PreparedStatement ps = conn.prepareStatement("INSERT INTO Order_Header (order_date, customer_id, shipping_contact_mech_id, billing_contact_mech_id) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

                // Set the prepared statement parameters
                ps.setString(1, orderDate);
                ps.setString(2, customerId);
                ps.setString(3, shippingContactId);
                ps.setString(4, billingContactId);

                // Execute the update and check the number of affected rows
                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            // If a new order was created, return the generated order ID
                            jsonResponse.put("status", "success");
                            jsonResponse.put("orderId", rs.getInt(1));
                        }
                    }
                } else {
                    jsonResponse.put("status", "error");
                    jsonResponse.put("message", "Order creation failed, no rows affected");
                }
            } catch (SQLException e) {
                jsonResponse.put("status", "error");
                jsonResponse.put("message", "Database error: " + e.getMessage());
            }
        }

        // Set response content type to JSON and send the response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());
    }
}
