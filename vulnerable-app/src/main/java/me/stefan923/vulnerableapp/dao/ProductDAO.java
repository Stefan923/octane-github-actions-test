package me.stefan923.vulnerableapp.dao;

public class ProductDAO {
    public int getItemPrice(String itemId) {
        // Întoarce preț fix pentru demonstrație
        return 100;
    }

    public int getStock(String productId) {
        // Întoarce stoc fix pentru demonstrație
        return 50;
    }

    public void updateStock(String productId, int newStock) {
        // Actualizează stoc în baza de date
    }
}