package com.testtask.task1.exception;

public class UserListReadException extends UserManagementSystemException {

    public UserListReadException() {
        super();
    }

    public UserListReadException(String message) {
        super(message);
    }

    public UserListReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserListReadException(Throwable cause) {
        super(cause);
    }

}
