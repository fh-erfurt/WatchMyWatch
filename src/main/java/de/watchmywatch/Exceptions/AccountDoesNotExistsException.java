package de.watchmywatch.Exceptions;

public class AccountDoesNotExistsException extends Exception
{
    private String message;

    public AccountDoesNotExistsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
