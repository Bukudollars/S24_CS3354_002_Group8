package com.waterboi.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    Appuser() {}

    public Appuser(String username, String password) {
        this.username = username.toLowerCase();
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
