package me.stefan923.vulnerableapp.util;

import java.util.Date;

public class ActivityLogger {
    public void logActivity(String userId, String action) {
        // Vulnerabilitate Log Injection
        System.out.println("[" + new Date() + "] User " + userId + " performed: " + action);
    }

    // Metodă securizată cu sanitizare
    public void logActivitySecure(String userId, String action) {
        String sanitizedAction = action.replace("\n", "").replace("\r", "");
        System.out.println("[" + new Date() + "] User " + userId + " performed: " + sanitizedAction);
    }
}