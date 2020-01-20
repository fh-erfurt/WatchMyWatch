package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManagerManufacturer
{
    @Test
    public void should_create_one_Manufacturers()
    {
        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        //When
        manufacturerManager.addManufacturer("Test", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), 1);
        //Then
        assertEquals(1, manufacturerManager.howManyManufacturers());
        manufacturerManager.removeManufacturerByName("Test");
    }

    @Test
    public void should_create_two_Manufacturers_and_delete_one()
    {
        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        manufacturerManager.addManufacturer("Test", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), 1);
        manufacturerManager.addManufacturer("Test2", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), 2);
        //When
        manufacturerManager.removeManufacturerByName("Test");
        //Then
        assertEquals(1, manufacturerManager.howManyManufacturers());
        manufacturerManager.removeManufacturerByName("Test2");
    }

    @Test
    public void should_create_one_Manufacturer_and_change_its_addressID()
    {
        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        manufacturerManager.addManufacturer("Test", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), 1);
        //When
        manufacturerManager.updateAddressByID(1, 2);
        //Then
        assertEquals(2, manufacturerManager.getManufacturerByID(1).getAddressID());
        manufacturerManager.removeManufacturerByName("Test");
    }
}
