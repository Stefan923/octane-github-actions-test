package me.stefan923.vulnerableapp.security;

import me.stefan923.vulnerableapp.util.SafeObjectInputStream;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class SessionManager {
    public User getUserFromSession(byte[] sessionData) {
        // Vulnerabilitate Insecure Deserialization
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(sessionData));
            return (User) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    // Metodă securizată cu deserializare controlată
    public User getUserFromSessionSecure(byte[] sessionData) {
        try {
            SafeObjectInputStream ois = new SafeObjectInputStream(new ByteArrayInputStream(sessionData));
            return (User) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}