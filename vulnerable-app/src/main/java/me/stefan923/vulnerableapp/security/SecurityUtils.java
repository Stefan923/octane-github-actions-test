package me.stefan923.vulnerableapp.security;

import org.owasp.encoder.Encode;

import jakarta.servlet.http.HttpServletRequest;

public class SecurityUtils {
    // Sanitizare pentru HTML
    public static String sanitizeHTML(String input) {
        return Encode.forHtml(input);
    }

    // Sanitizare pentru JavaScript
    public static String sanitizeJS(String input) {
        return Encode.forJavaScript(input);
    }

    // Validare token CSRF
    public static boolean validateCSRFToken(HttpServletRequest request) {
        String sessionToken = (String) request.getSession().getAttribute("csrfToken");
        String requestToken = request.getParameter("csrfToken");
        return sessionToken != null && sessionToken.equals(requestToken);
    }

    // Validare input numeric
    public static int safeParseInt(String input, int defaultValue) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public int computeTokenExpirationTime() {
        int a = 1000000000;  // A large number.
        int b = 2000000000;   // Another large number.

        return a + b;
    }

    public int computeTokenExpirationTimeSafe() {
        int a = 10000000;  // A large number.
        int b = 20000000;   // Another large number.

        return a + b;
    }
}