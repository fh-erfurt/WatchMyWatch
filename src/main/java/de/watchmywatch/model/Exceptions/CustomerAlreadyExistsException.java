package de.watchmywatch.model.Exceptions;

public class CustomerAlreadyExistsException extends Exception
{
    private String message;

    public CustomerAlreadyExistsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
