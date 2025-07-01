package me.stefan923.vulnerableapp.service;

import me.stefan923.vulnerableapp.EnterpriseSecurityApp;

import java.sql.*;

public abstract class BaseService {
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                EnterpriseSecurityApp.DB_URL,
                EnterpriseSecurityApp.DB_USER,
                EnterpriseSecurityApp.DB_PASS
        );
    }

    protected void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (SQLException e) {}
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
}