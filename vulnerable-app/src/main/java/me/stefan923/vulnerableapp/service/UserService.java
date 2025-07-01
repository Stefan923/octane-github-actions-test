package me.stefan923.vulnerableapp.service;

import me.stefan923.vulnerableapp.EnterpriseSecurityApp;
import org.owasp.encoder.Encode;

import java.sql.*;

public class UserService {
    public String getUserDetails(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection(
                EnterpriseSecurityApp.DB_URL,
                EnterpriseSecurityApp.DB_USER,
                EnterpriseSecurityApp.DB_PASS
        );

        // Vulnerabilitate SQL Injection
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + userId);

        StringBuilder userDetails = new StringBuilder();
        userDetails.append("<div class='user-profile'>");

        while (rs.next()) {
            userDetails.append("<h1>").append(rs.getString("name")).append("</h1>");
            userDetails.append("<p>Email: ").append(rs.getString("email")).append("</p>");
            userDetails.append("<p>Phone: ").append(rs.getString("phone")).append("</p>");
        }

        userDetails.append("</div>");
        return userDetails.toString();
    }

    // Metodă securizată cu prepared statement
    public String getUserDetailsSecure(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection(
                EnterpriseSecurityApp.DB_URL,
                EnterpriseSecurityApp.DB_USER,
                EnterpriseSecurityApp.DB_PASS
        );

        String query = "SELECT * FROM users WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, userId);
        ResultSet rs = stmt.executeQuery();

        StringBuilder userDetails = new StringBuilder();
        userDetails.append("<div class='user-profile'>");

        while (rs.next()) {
            userDetails.append("<h1>").append(Encode.forHtml(rs.getString("name"))).append("</h1>");
            userDetails.append("<p>Email: ").append(Encode.forHtml(rs.getString("email"))).append("</p>");
            userDetails.append("<p>Phone: ").append(Encode.forHtml(rs.getString("phone"))).append("</p>");
        }

        userDetails.append("</div>");
        return userDetails.toString();
    }
}