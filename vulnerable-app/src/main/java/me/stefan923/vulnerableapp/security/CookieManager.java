package me.stefan923.vulnerableapp.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {
    public void setAuthCookie(HttpServletResponse response, String token) {
        // Vulnerabilitate Cookie Without Secure Flag
        Cookie cookie = new Cookie("authToken", token);
        response.addCookie(cookie);
    }

    // Metodă securizată cu atribute corecte
    public void setSecureAuthCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("authToken", token);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}