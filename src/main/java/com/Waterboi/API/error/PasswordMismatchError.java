package com.Waterboi.API.error;

public class PasswordMismatchError extends Error{
    public PasswordMismatchError() {
        super("Password mismatch");
    }
    public PasswordMismatchError(String message) {
        super(message);
    }
}
