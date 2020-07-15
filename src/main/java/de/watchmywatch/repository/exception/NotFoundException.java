package de.watchmywatch.repository.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String name) {
        super("Could not find " + name);
    }
    public NotFoundException(String name, int id) {
        super("Could not find " + name + " with Id: " + id);
    }
}
