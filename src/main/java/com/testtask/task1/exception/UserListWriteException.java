package com.testtask.task1.exception;

public class UserListWriteException extends UserManagementSystemException {
    public UserListWriteException() {
        super();
    }

    public UserListWriteException(String message) {
        super(message);
    }

    public UserListWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserListWriteException(Throwable cause) {
        super(cause);
    }
}
