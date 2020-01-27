package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWatchpart
{
    //create some reusable objects
    Address address = new Address("street", "city", "state", "zip");
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);

    @Test
    public void should_create_a_valid_casing()
    {
        //Given
        // When
        Casing casing = new Casing(manufacturer,"id", Material.ALUMINIUM,1.00,2.00,2.00,ConnectionType.BAND);
        //Then
        assertEquals(true, casing.validate());
    }

    @Test
    public void should_create_a_valid_bracelet()
    {
        //Given
        // When
        Bracelet bracelet = new Bracelet(manufacturer,"ID",Material.ALUMINIUM,2.00,2.00,ConnectionType.BAND);
        //Then
        assertEquals(true, bracelet.validate());
    }

    @Test
    public void should_create_a_valid_clockwork()
    {
        //Given
        // When
        Clockwork clockwork = new Clockwork(manufacturer,"ID",Material.ALUMINIUM,2.00,2.00);
        //Then
        assertEquals(true, clockwork.validate());
    }

    //TODO testx for nan valid watchparts
}
