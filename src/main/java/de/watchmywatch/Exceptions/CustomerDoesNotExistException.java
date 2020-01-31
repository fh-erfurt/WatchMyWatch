package de.watchmywatch.Exceptions;

public class CustomerDoesNotExistException extends Throwable
{
    private String message;

    public CustomerDoesNotExistException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
