package me.stefan923.vulnerableapp;

import jakarta.servlet.*;

import java.io.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.stefan923.vulnerableapp.controller.*;

public class EnterpriseSecurityApp extends HttpServlet {

    // Configurație aplicație
    public static final String DB_URL = "jdbc:mysql://localhost:3306/enterprise_db";
    public static final String DB_USER = "admin";
    public static final String DB_PASS = "admin123";

    public static void main(String[] args) {
        // Cod pentru testare locală
        System.out.println("Enterprise Security Application");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("userProfile".equals(action)) {
            new UserProfileController().showProfile(request, response);
        } else if ("productSearch".equals(action)) {
            new ProductSearchController().searchProducts(request, response);
        } else if ("checkout".equals(action)) {
            new CheckoutController().processCheckout(request, response);
        } else if ("adminReports".equals(action)) {
            new AdminReportController().generateReport(request, response);
        } else if ("dataImport".equals(action)) {
            new DataImportController().importData(request, response);
        } else {
            response.getWriter().println("Invalid action specified");
        }
    }
}
