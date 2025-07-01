package me.stefan923.vulnerableapp.security;

import java.io.Serializable;

public class User implements Serializable {
    public String id;
    public String name;
    public String email;
    public String passwordHash;
    public String creditCard;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}