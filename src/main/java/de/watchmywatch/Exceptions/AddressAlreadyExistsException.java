package de.watchmywatch.Exceptions;

public class AddressAlreadyExistsException extends Exception
{
        private String message;

        public AddressAlreadyExistsException(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
}
