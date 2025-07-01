package me.stefan923.vulnerableapp.controller;

import me.stefan923.vulnerableapp.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckoutController {
    public void processCheckout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String items = request.getParameter("items");

        OrderService orderService = new OrderService();
        orderService.placeOrder(userId, items);

        response.getWriter().println("Order processed successfully");
    }
}