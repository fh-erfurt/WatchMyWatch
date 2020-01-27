package de.watchmywatch.Bestellungsverwaltung;
import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Exceptions.NameException;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.Uhrenverwaltung.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShoppingcart
{
    // create some reusable objects
    Address address = new Address("Lilo-Herrmann-Straße","Erfurt", "Thüringen", "99086");
    Manufacturer manufacturer = new Manufacturer("Apple",  new Person("anton.bespalov@fh-erfurt.de", address,
            "01716181447", "Anton", "Bespalov"), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM,2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM,2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM,2, 2);
    Watch watch = new Watch("Swatch", "Test", bracelet, casing, clockwork);

    // TODO: Preisberechnung über Einzelteile steuern.
    public TestShoppingcart() throws NameException
    {
    }

    @Test
    public void should_return_zero_as_total_for_new_shoppingcart()
    {
    //Given
        Shoppingcart shoppingcart = new Shoppingcart();
    // When

    //Then
        assertEquals( 0.0 , shoppingcart.getTotal());
    }

    @Test
    public void should_add_a_watch_to_shoppingcart()
    {
    //Given
        Shoppingcart shoppingcart = new Shoppingcart();
    // When
        shoppingcart.addWatch(watch);
    //Then
        ArrayList<Watch> list = shoppingcart.getItems();
        boolean foundWatch = list.contains(watch);
        assertEquals( true , foundWatch);
    }


    @Test
    public void should_remove_a_watch_from_shoppingcart()
    {
    //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
    // When
        shoppingcart.removeWatch(watch);
    //Then
        ArrayList<Watch> list = shoppingcart.getItems();
        boolean foundWatch = false;
        if(!list.isEmpty())
        {
            foundWatch = list.contains(watch);
        }
        assertEquals( false , foundWatch);
    }

    @Test
    public void should_remove_only_one_of_multiple_identical_watches_from_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        shoppingcart.removeWatch(watch);
        //Then
        ArrayList<Watch> list = shoppingcart.getItems();
        boolean foundWatch = false;
        if(!list.isEmpty())
        {
            foundWatch = list.contains(watch);
        }
        assertEquals( true , foundWatch);
    }

    @Test
    public void should_remove_all_occurances_of_given_watch_from_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        shoppingcart.removeAllOccurancesOfWatch(watch);
        //Then
        ArrayList<Watch> list = shoppingcart.getItems();
        boolean foundWatch = false;
        if(!list.isEmpty())
        {
            foundWatch = list.contains(watch);
        }
        assertEquals( false , foundWatch);
    }

    @Test
    public void should_remove_the_two_occurances_of_given_watch_from_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        int occurances = shoppingcart.removeAllOccurancesOfWatch(watch);
        //Then
        assertEquals( 2 , occurances);
    }

    @Test
    public void should_return_110_as_new_total_for_shoppingcart() throws NameException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        // When
        shoppingcart.removeWatch(watch1);
        //Then
        assertEquals( 110 , shoppingcart.getTotal());
    }

    @Test
    public void should_return_zero_as_new_total_for_shoppingcart() throws NameException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        // When
        shoppingcart.removeAllOccurancesOfWatch(watch1);
        //Then
        assertEquals( 0.0 , shoppingcart.getTotal());
    }

    @Test
    public void should_return_220_as_new_total_for_shoppingcart() throws NameException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        Watch watch2 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch2);
        // When
        shoppingcart.removeWatch(watch2);
        //Then
        assertEquals( 220 , shoppingcart.getTotal());
    }

    @Test
    public void should_return_330_as_new_total_for_shoppingcart() throws NameException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        Watch watch2 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch2);
        // When
        shoppingcart.removeAllOccurancesOfWatch(watch1);
        //Then
        assertEquals( 330 , shoppingcart.getTotal());
    }

    @Test
    public void should_return_440_as_new_total_for_shoppingcart() throws NameException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        Watch watch2 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch2);
        // When
        shoppingcart.removeWatch(watch1);
        //Then
        assertEquals( 440 , shoppingcart.getTotal());
    }

    @Test
    public void should_empty_shoppingcart_completely()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        shoppingcart.clear();
        //Then
        assertEquals( true , shoppingcart.getItems().isEmpty());
    }

    @Test
    public void should_return_zero_as_total_after_clearing_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        shoppingcart.clear();
        //Then
        assertEquals( 0.0 , shoppingcart.getTotal());
    }
}
