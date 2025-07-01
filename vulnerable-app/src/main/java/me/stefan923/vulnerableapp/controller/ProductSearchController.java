package me.stefan923.vulnerableapp.controller;

import me.stefan923.vulnerableapp.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProductSearchController {
    public void searchProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = request.getParameter("query");
        ProductService productService = new ProductService();

        try {
            String results = productService.searchProducts(query);
            response.getWriter().println(results);
        } catch (SQLException e) {
            response.sendError(500, "Search failed");
        }
    }
}