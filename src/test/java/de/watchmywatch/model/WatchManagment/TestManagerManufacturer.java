package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * class which tests the functionality of ManagerManufacturer
 */
public class TestManagerManufacturer
{
    Address address = new Address("street", "city", "state", "zip");

    @Test
    public void should_create_one_Manufacturers()
    {
        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        //When
        Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23)), address);
        //Then
        assertEquals(1, manufacturerManager.amountOfManufacturers());
        manufacturerManager.removeManufacturerByName("Test");
    }

    @Test
    public void should_create_two_Manufacturers_and_delete_one()
    {


        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        manufacturerManager.addManufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov",LocalDate.of(1998, 9, 23)), address);
        manufacturerManager.addManufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
                "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov",LocalDate.of(1998, 9, 23)), address);
        //When
        manufacturerManager.removeManufacturerByName("Test");
        //Then
        assertEquals(1, manufacturerManager.amountOfManufacturers());
        manufacturerManager.removeManufacturerByName("Test2");
    }
}
