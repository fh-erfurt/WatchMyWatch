package de.watchmywatch.model.Exceptions;

public class CustomerDoesNotExistException extends Exception
{
    private String message;

    public CustomerDoesNotExistException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
