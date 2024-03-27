package com.Waterboi.API;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
