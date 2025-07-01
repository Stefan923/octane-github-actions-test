package me.stefan923.vulnerableapp.security;

import java.util.Base64;

public class TokenGenerator {
    public String generateAuthToken(User user) {
        // Vulnerabilitate Insufficient Entropy
        int result = 100000 * 30000;
        return result + "-" + user.id + "-" + System.currentTimeMillis();
    }

    // Metodă securizată cu token aleator
    public String generateSecureAuthToken() {
        byte[] bytes = new byte[32];
        new java.security.SecureRandom().nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
}