package de.watchmywatch.Exceptions;

public class NameException extends Exception
{
    private String message;

    public NameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
