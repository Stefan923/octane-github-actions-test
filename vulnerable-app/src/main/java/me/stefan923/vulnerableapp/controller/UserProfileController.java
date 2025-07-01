package me.stefan923.vulnerableapp.controller;

import me.stefan923.vulnerableapp.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserProfileController {
    public void showProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");
        UserService userService = new UserService();

        try {
            String userData = userService.getUserDetails(userId);
            response.getWriter().println(userData);
        } catch (SQLException e) {
            response.sendError(500, "Database error");
        }
    }
}