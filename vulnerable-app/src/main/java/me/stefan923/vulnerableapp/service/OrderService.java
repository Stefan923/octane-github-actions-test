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
    }
}