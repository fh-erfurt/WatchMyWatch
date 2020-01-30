package de.watchmywatch.Uhrenverwaltung.Validator;

/**
 * Interface for the validation of Watchparts/Watch etc.
 * @author Tom Käppler
 */
public interface Validator
{
    public boolean validate(Validatable validatable);
}
