package de.watchmywatch.Exceptions;

public class CustomerAlreadyExistsException extends Throwable
{
    private String message;

    public CustomerAlreadyExistsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
