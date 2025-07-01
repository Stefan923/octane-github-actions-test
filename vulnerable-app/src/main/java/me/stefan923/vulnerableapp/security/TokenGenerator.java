package me.stefan923.vulnerableapp.security;

import java.util.Base64;

public class TokenGenerator {
    public String generateAuthToken(User user) {
        // Vulnerabilitate Insufficient Entropy
        return user.id + "-" + System.currentTimeMillis();
    }

    // Metodă securizată cu token aleator
    public String generateSecureAuthToken() {
        byte[] bytes = new byte[32];
        new java.security.SecureRandom().nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
}