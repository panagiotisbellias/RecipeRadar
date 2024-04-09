package com.github.donaldwilson8.exception;

public class CustomExceptions {

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static class DuplicateUserException extends RuntimeException {
        public DuplicateUserException(String message) {
            super(message);
        }
    }

    public static class EdamamApiException extends RuntimeException {
        public EdamamApiException(String message) { super(message); }
    }

}
