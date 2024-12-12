package com.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.ecommerce.utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TestDBServlets")  // Servlet URL mapping
public class TestDBServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET request to test database connection
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Test database connection
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            out.println("<h1>Database connected successfully!</h1>");
        } else {
            out.println("<h1>Database connection failed.</h1>");
        }
    }
}
