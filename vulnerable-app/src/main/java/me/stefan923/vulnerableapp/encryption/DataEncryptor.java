package me.stefan923.vulnerableapp.encryption;

import java.util.Base64;

public class DataEncryptor {
    public String encryptData(String data) {
        // Vulnerabilitate Weak Encryption
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    // Metodă securizată cu AES
    public String encryptDataSecure(String data) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
        // Implementare completă de criptare...
        return "encrypted_data";
    }
}