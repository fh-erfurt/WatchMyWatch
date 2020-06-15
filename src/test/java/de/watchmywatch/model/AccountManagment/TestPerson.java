package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class which tests the functionality of Person
 * @author  Anton Bespalov
 */
public class TestPerson
{
    @Test
    public void should_create_a_Person_with_email()
    {
        Person person1 = new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov");

        assertEquals("anton.bespalov@fh-erfurt.de", person1.getEmail());
    }

    @Test
    public void should_create_a_Person_with_phone()
    {
        Person person1 = new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov");

        assertEquals("01716181447", person1.getPhone());
    }
}