package me.stefan923.vulnerableapp.dao;

import me.stefan923.vulnerableapp.EnterpriseSecurityApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionManager {
    private static final int MAX_POOL_SIZE = 10;
    private static List<Connection> connectionPool = new ArrayList<>();

    static {
        initializePool();
    }

    private static void initializePool() {
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            try {
                Connection conn = DriverManager.getConnection(
                        EnterpriseSecurityApp.DB_URL,
                        EnterpriseSecurityApp.DB_USER,
                        EnterpriseSecurityApp.DB_PASS
                );
                connectionPool.add(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            throw new SQLException("Connection pool exhausted");
        }
        return connectionPool.remove(0);
    }

    public static synchronized void releaseConnection(Connection conn) {
        connectionPool.add(conn);
    }
}