package org.myorg.persistence;

public class UserServiceException extends Exception {
    public static final String WRONG_CREDENTIALS = "Wrong username or password";
    public UserServiceException(String message) {
        super(message);
    }
}
