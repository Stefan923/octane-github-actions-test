package me.stefan923.vulnerableapp.processor;

import me.stefan923.vulnerableapp.dao.ProductDAO;

import java.math.BigInteger;

public class PaymentProcessor {
    public int calculateTotal(String items) {
        ProductDAO productDao = new ProductDAO();
        int total = 0;

        for (String item : items.split(",")) {
            total += productDao.getItemPrice(item) * 100; // Convert to cents
        }

        // Vulnerabilitate Integer Overflow
        return total * 100; // Additional multiplier for demo
    }

    // Metodă securizată pentru calcul plăți
    public BigInteger calculateTotalSecure(String items) {
        ProductDAO productDao = new ProductDAO();
        BigInteger total = BigInteger.ZERO;

        for (String item : items.split(",")) {
            int price = productDao.getItemPrice(item);
            total = total.add(BigInteger.valueOf(price).multiply(BigInteger.valueOf(100)));
        }

        return total;
    }
}