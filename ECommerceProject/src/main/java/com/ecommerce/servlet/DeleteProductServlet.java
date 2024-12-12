package com.ecommerce.servlet;

import com.ecommerce.dao.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        boolean success = ProductDAO.deleteProductById(id);

        if (success) {
            request.setAttribute("message", "Product deleted successfully!");
        } else {
            request.setAttribute("message", "Failed to delete product. Try again.");
        }

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
