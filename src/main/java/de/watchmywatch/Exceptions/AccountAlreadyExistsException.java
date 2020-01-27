package de.watchmywatch.Exceptions;

public class AccountAlreadyExistsException extends Exception
{
    private String message;

    public AccountAlreadyExistsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
