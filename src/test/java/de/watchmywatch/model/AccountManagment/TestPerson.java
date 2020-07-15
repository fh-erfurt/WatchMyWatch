package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.Address;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        Customer customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23));

        assertEquals("anton.bespalov@fh-erfurt.de", customer.getEmail());
    }

    @Test
    public void should_create_a_Person_with_phone()
    {
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        Customer customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23));

        assertEquals("01716181447", customer.getPhone());
    }
}
