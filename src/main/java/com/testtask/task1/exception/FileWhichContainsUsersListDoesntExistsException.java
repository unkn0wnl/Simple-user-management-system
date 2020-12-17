package com.testtask.task1.exception;

public class FileWhichContainsUsersListDoesntExistsException extends UserManagementSystemException {

    public FileWhichContainsUsersListDoesntExistsException() {
        super();
    }

    public FileWhichContainsUsersListDoesntExistsException(String message) {
        super(message);
    }

    public FileWhichContainsUsersListDoesntExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWhichContainsUsersListDoesntExistsException(Throwable cause) {
        super(cause);
    }

}