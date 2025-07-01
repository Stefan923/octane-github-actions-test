package me.stefan923.vulnerableapp.service;

import me.stefan923.vulnerableapp.EnterpriseSecurityApp;

import java.sql.*;
import java.util.Scanner;

public class ProductService {
    public String searchProducts(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(
                EnterpriseSecurityApp.DB_URL,
                EnterpriseSecurityApp.DB_USER,
                EnterpriseSecurityApp.DB_PASS
        );

        query = new Scanner(System.in).nextLine();

        // Vulnerabilitate SQL Injection
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM products WHERE name LIKE '%" + query + "%'"
        );

        StringBuilder results = new StringBuilder();
        results.append("<ul class='product-list'>");

        while (rs.next()) {
            results.append("<li>")
                    .append(rs.getString("name"))
                    .append(" - $")
                    .append(rs.getDouble("price"))
                    .append("</li>");
        }

        results.append("</ul>");
        return results.toString();
    }
}