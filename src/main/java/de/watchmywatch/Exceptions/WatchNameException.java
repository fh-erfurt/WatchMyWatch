package de.watchmywatch.Exceptions;

public class WatchNameException extends Exception
{
    private String message;

    public WatchNameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
