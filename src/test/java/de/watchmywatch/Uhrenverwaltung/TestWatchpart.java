package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWatchpart
{
    //create some reusable objects
    Manufacturer manufacturer = new Manufacturer("Apple", new Person(), 1);

    @Test
    public void should_create_a_valid_casing()
    {
        //Given
        // When
        Casing casing = new Casing(manufacturer,"id", Material.ALUMINIUM,1,2.00,2.00,2.00,ConnectionType.BAND);
        //Then
        assertEquals(true, casing.validate());
    }

    @Test
    public void should_create_a_valid_bracelet()
    {
        //Given
        // When
        Bracelet bracelet = new Bracelet(manufacturer,"ID",Material.ALUMINIUM,2,2.00,2.00,ConnectionType.BAND);
        //Then
        assertEquals(true, bracelet.validate());
    }

    @Test
    public void should_create_a_valid_clockwork()
    {
        //Given
        // When
        Clockwork clockwork = new Clockwork(manufacturer,"ID",Material.ALUMINIUM,2,2.00,2.00);
        //Then
        assertEquals(true, clockwork.validate());
    }

    //TODO testx for nan valid watchparts
}
