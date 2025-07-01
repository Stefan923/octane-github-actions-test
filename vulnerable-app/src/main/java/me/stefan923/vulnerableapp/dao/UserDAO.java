package me.stefan923.vulnerableapp.dao;

import me.stefan923.vulnerableapp.EnterpriseSecurityApp;
import me.stefan923.vulnerableapp.security.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    public void saveUser(User user) throws SQLException {
        Connection conn = DriverManager.getConnection(
                EnterpriseSecurityApp.DB_URL,
                EnterpriseSecurityApp.DB_USER,
                EnterpriseSecurityApp.DB_PASS
        );

        String query = "INSERT INTO users VALUES ('" + user.id + "', '" +
                user.name + "', '" + user.email + "')";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
}