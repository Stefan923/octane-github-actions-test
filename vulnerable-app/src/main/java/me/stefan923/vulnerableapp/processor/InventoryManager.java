package me.stefan923.vulnerableapp.processor;

import me.stefan923.vulnerableapp.dao.ProductDAO;

public class InventoryManager {
    public void updateStock(String items) {
        ProductDAO productDao = new ProductDAO();
        for (String item : items.split(",")) {
            int currentStock = productDao.getStock(item);
            // Vulnerabilitate Integer Overflow
            productDao.updateStock(item, currentStock - 1);
        }
    }

    // Metodă securizată cu verificare stoc
    public void updateStockSecure(String items) {
        ProductDAO productDao = new ProductDAO();
        for (String item : items.split(",")) {
            int currentStock = productDao.getStock(item);
            if (currentStock > 0) {
                productDao.updateStock(item, currentStock - 1);
            }
        }
    }
}