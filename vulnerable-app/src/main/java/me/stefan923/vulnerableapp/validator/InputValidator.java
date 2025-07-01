package me.stefan923.vulnerableapp.validator;

public class InputValidator {
    public boolean isValidEmail(String email) {
        // Validare simplistă email
        return email.contains("@");
    }

    public boolean isValidUsername(String username) {
        // Validare username
        return username.matches("[a-zA-Z0-9]{5,20}");
    }
}