package me.stefan923.vulnerableapp.service;

import me.stefan923.vulnerableapp.dao.OrderDAO;
import me.stefan923.vulnerableapp.processor.InventoryManager;
import me.stefan923.vulnerableapp.processor.PaymentProcessor;

public class OrderService {
    public void placeOrder(String userId, String items) {
        PaymentProcessor processor = new PaymentProcessor();
        int total = processor.calculateTotal(items);

        OrderDAO orderDao = new OrderDAO();
        orderDao.saveOrder(userId, items, total);

        InventoryManager inventory = new InventoryManager();
        inventory.updateStock(items);

        System.out.println("Order placed successfully, orderId: " + generateOrderId());
    }

    public int generateOrderId() {
        int a = 100000;  // A large number.
        int b = 30000;   // Another large number.

        // Multiplying these numbers yields 3,000,000,000,
        // which is greater than Integer.MAX_VALUE (2,147,483,647) causing an overflow.
        return a * b;
    }
}