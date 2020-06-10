package de.watchmywatch.model.Exceptions;

public class WatchNameNotValidException extends Exception
{
    private String message;

    public WatchNameNotValidException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
