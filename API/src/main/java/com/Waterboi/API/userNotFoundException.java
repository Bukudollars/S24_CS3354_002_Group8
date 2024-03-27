package com.Waterboi.API;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(Long id) {
        super("Could not find user " + id);
    }

    public userNotFoundException(String username) {
        super("Could not find user " + username);
    }
}
