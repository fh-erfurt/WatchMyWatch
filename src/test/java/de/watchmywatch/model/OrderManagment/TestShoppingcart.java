package de.watchmywatch.model.OrderManagment;

import de.watchmywatch.model.AccountManagment.Person;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class which tests the functionality of Shoppingcart
 * @author Michael Hopp
 */
public class TestShoppingcart
{
    // create some reusable objects
    Address address = new Address("street", "city", "state", "zip");
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 25, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 25, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 50, 2);
    Watch watch = new Watch("Swatch", "Test", bracelet, casing, clockwork);


    public TestShoppingcart() throws WatchNameNotValidException
    {
    }

    @Test
    public void should_return_zero_as_total_for_new_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        // When

        //Then
        assertEquals(0.0, shoppingcart.getTotal());
    }

    @Test
    public void should_add_a_watch_to_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        // When
        shoppingcart.addWatch(watch);
        //Then
        List<Watch> list = shoppingcart.getItems();    // Extra steps for showing/testing used DataType
        boolean foundWatch = list.contains(watch);
        assertTrue(foundWatch);
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
        List<Watch> list = shoppingcart.getItems();
        boolean foundWatch = false;
        if (!list.isEmpty()) // Empty shoppingcart means no watches anyway
        {
            foundWatch = list.contains(watch);
        }
        assertFalse(foundWatch);
    }

    @Test
    public void should_remove_only_one_of_multiple_identical_watches_from_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        shoppingcart.removeWatch(watch);    // Remove only one occurance of given watch
        //Then
        assertTrue(shoppingcart.getItems().contains(watch));    // Shoppingcart should still have one of those watches left
    }

    @Test
    public void should_remove_all_occurrences_of_given_watch_from_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        shoppingcart.removeAllOccurrencesOfWatch(watch);
        //Then
        List<Watch> list = shoppingcart.getItems();
        boolean foundWatch = false;
        if (!list.isEmpty())     // Empty shoppingcart means no watches anyway
        {
            foundWatch = list.contains(watch);
        }
        assertFalse(foundWatch);
    }

    @Test
    public void should_remove_the_two_occurrences_of_given_watch_from_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        int occurances = shoppingcart.removeAllOccurrencesOfWatch(watch);    // Count how many Occurances were removed
        //Then
        assertEquals(2, occurances);
    }

    @Test
    public void should_return_110_as_new_total_for_shoppingcart() throws WatchNameNotValidException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        // When
        shoppingcart.removeWatch(watch1);   // One watch1 should be remaining
        //Then
        assertEquals(110, shoppingcart.getTotal());
    }

    @Test
    public void should_return_zero_as_new_total_for_shoppingcart() throws WatchNameNotValidException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        // When
        shoppingcart.removeAllOccurrencesOfWatch(watch1);    // Shoppingcart is empty afterwards
        //Then
        assertEquals(0.0, shoppingcart.getTotal());
    }

    @Test
    public void should_return_220_as_new_total_for_shoppingcart() throws WatchNameNotValidException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        Watch watch2 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch2);
        // When
        shoppingcart.removeWatch(watch2);   // Two Occurances of watch1 remaining
        //Then
        assertEquals(220, shoppingcart.getTotal());
    }

    @Test
    public void should_return_330_as_new_total_for_shoppingcart() throws WatchNameNotValidException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        Clockwork clockwork1 = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 250, 2);
        Watch watch2 = new Watch("Swatch", "Test", bracelet, casing, clockwork1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch2);
        // When
        shoppingcart.removeAllOccurrencesOfWatch(watch1);    // Only Expensive watch2 should be remaining
        //Then
        assertEquals(330, shoppingcart.getTotal());
    }

    @Test
    public void should_return_440_as_new_total_for_shoppingcart() throws WatchNameNotValidException
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        Watch watch1 = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        Clockwork clockwork1 = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 250, 2);
        Watch watch2 = new Watch("Swatch", "Test", bracelet, casing, clockwork1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch1);
        shoppingcart.addWatch(watch2);  // More expensive Watch
        // When
        shoppingcart.removeWatch(watch1);   // watch2 and one watch1 should be remaining
        //Then
        assertEquals(440, shoppingcart.getTotal());
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
        assertTrue(shoppingcart.getItems().isEmpty());
    }

    @Test
    public void should_return_zero_as_total_after_clearing_shoppingcart()
    {
        //Given
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);   // Add a couple of watches
        shoppingcart.addWatch(watch);
        shoppingcart.addWatch(watch);
        // When
        shoppingcart.clear();   // Resetting Shoppingcart
        //Then
        assertEquals(0.0, shoppingcart.getTotal());
    }
}
