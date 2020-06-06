package de.watchmywatch.model.Exceptions;

public class ShoppingcartEmptyException extends Exception
{
    private String message;

    public ShoppingcartEmptyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
