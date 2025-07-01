package me.stefan923.vulnerableapp.encryption;

public class BCrypt {
    public static String hashpw(String password, Object salt) {
        return "hashed_password";
    }

    public static boolean checkpw(String plaintext, String hashed) {
        return hashed.equals(hashpw(plaintext, null));
    }
}