package me.stefan923.vulnerableapp.security;

import me.stefan923.vulnerableapp.encryption.BCrypt;

public class AuthManager {
    public boolean authenticate(String username, String password) {
        // Vulnerabilitate Weak Cryptography
        String storedHash = getPasswordHash(username);
        return md5(password).equals(storedHash);
    }

    // Metodă securizată cu bcrypt
    public boolean authenticateSecure(String username, String password) {
        String storedHash = getPasswordHash(username);
        return BCrypt.checkpw(password, storedHash);
    }

    private String getPasswordHash(String username) {
        // Întoarce hash din baza de date
        return "5f4dcc3b5aa765d61d8327deb882cf99"; // MD5 pentru "password"
    }

    private String md5(String input) {
        // Implementare simplistă MD5
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            return "";
        }
    }
}