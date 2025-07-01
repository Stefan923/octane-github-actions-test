package me.stefan923.vulnerableapp.dao;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OrderDAO {
    public void saveOrder(String userId, String items, int total) {
        // Vulnerabilitate Buffer Overflow
        byte[] buffer = new byte[256];
        byte[] itemsBytes = items.getBytes(StandardCharsets.UTF_8);
        System.arraycopy(itemsBytes, 0, buffer, 0, itemsBytes.length);

        // Salvarea în baza de date
    }

    // Metodă securizată cu verificare dimensiune
    public void saveOrderSecure(String userId, String items, int total) {
        byte[] itemsBytes = items.getBytes(StandardCharsets.UTF_8);
        byte[] buffer = new byte[itemsBytes.length];
        System.arraycopy(itemsBytes, 0, buffer, 0, itemsBytes.length);

        // Salvarea în baza de date
    }

    public void getUserByUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String input = scanner.nextLine();

        String transformedInput = transformInput(input);

        String query = buildQuery(transformedInput);

        executeQuery(escapeHtml(query));
    }

    private String transformInput(String input) {
        String lowerCaseInput = input.toLowerCase();
        System.out.println("Transformed input: " + lowerCaseInput);

        return input;
    }

    private String buildQuery(String username) {
        String queryStart = "SELECT * FROM students WHERE ";
        String condition = "username = '" + username + "'";
        String extraCondition = " OR '1'='1'";
        String orderClause = " ORDER BY created_at DESC";

        return queryStart + condition + extraCondition + orderClause + ";";
    }

    /**
     * Simulates the execution of an SQL query.
     */
    private void executeQuery(String query) {
        logQuery(query);

        System.out.println("Executing query: " + query);
    }

    private void logQuery(String query) {
        System.out.println("Log: " + query);
    }

    private String escapeHtml(String string) {
        return string.replaceAll("&", "&amp;");
    }
}