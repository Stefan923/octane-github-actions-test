package me.stefan923.vulnerableapp.security;

import jakarta.servlet.http.HttpServletRequest;

public class CSRFTokenValidator {
    public boolean isValidToken(HttpServletRequest request) {
        String sessionToken = (String) request.getSession().getAttribute("csrfToken");
        String requestToken = request.getParameter("csrfToken");

        if (sessionToken == null || requestToken == null) {
            return false;
        }

        return sessionToken.equals(requestToken);
    }
}