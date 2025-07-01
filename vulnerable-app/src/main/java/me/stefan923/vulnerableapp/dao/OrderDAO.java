package me.stefan923.vulnerableapp.dao;

import java.nio.charset.StandardCharsets;

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
}