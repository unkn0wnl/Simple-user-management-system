package com.testtask.task1.exception;

public class UserManagementSystemException extends RuntimeException{

    public UserManagementSystemException() {
        super();
    }

    public UserManagementSystemException(String message) {
        super(message);
    }

    public UserManagementSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserManagementSystemException(Throwable cause) {
        super(cause);
    }

}
