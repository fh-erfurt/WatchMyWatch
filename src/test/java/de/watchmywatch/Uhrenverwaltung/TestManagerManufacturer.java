package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
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
        //manufacturerManager.addManufacturer("Test", new Person(), 1);
        //Then
        assertEquals(1, manufacturerManager.howManyManufacturers());
        manufacturerManager.removeManufacturerByName("Test");
    }

    @Test
    public void should_create_two_Manufacturers_and_delete_one()
    {
        //Given
        ManagerManufacturer manufacturerManager = new ManagerManufacturer();
        //manufacturerManager.addManufacturer("Test", new Person(), 1);
        //manufacturerManager.addManufacturer("Test2", new Person(), 2);
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
        //manufacturerManager.addManufacturer("Test", new Person(), 1);
        //When
        manufacturerManager.updateAddressByID(1, 2);
        //Then
        assertEquals(2, manufacturerManager.getManufacturerByID(1).getAddressID());
        manufacturerManager.removeManufacturerByName("Test");
    }
}
