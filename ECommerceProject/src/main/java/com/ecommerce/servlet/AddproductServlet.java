package com.ecommerce.servlet;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addProduct")
public class AddproductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        boolean success = ProductDAO.addProduct(product);

        if (success) {
            request.setAttribute("message", "Product added successfully!");
        } else {
            request.setAttribute("message", "Failed to add product. Try again.");
        }

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
