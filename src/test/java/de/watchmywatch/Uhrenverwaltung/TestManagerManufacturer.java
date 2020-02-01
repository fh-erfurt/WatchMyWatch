package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManagerManufacturer
{
    Address address = new Address("street", "city", "state", "zip");

    @Test
    public void should_create_one_Manufacturers()
    {
        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        //When
        manufacturerManager.addManufacturer("Test", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);
        //Then
        assertEquals(1, manufacturerManager.amountOfManufacturers());
        manufacturerManager.removeManufacturerByName("Test");
    }

    @Test
    public void should_create_two_Manufacturers_and_delete_one()
    {
        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        manufacturerManager.addManufacturer("Test", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);
        manufacturerManager.addManufacturer("Test2", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);
        //When
        manufacturerManager.removeManufacturerByName("Test");
        //Then
        assertEquals(1, manufacturerManager.amountOfManufacturers());
        manufacturerManager.removeManufacturerByName("Test2");
    }
}
