package de.watchmywatch.model.OrderManagment;

import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class which tests the functionality of Shoppingcart
 *
 * @author Michael Hopp
 */

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class TestShoppingcart {
    // create some reusable objects
    Address address1;
    User user1;
    Manufacturer manufacturer1;
    Bracelet bracelet1;
    Casing casing1;
    Clockwork clockwork1;
    Bracelet bracelet2;
    Casing casing2;
    Clockwork clockwork2;
    Watch watch1;
    Watch watch2;
    Shoppingcart shoppingcart1;

    @BeforeEach
    void setUp() {
        address1 = new Address("street 2", "city", "state", "012345");
        user1 = new User("Test", "User", "user@mail.com", "password",
                "01716181447", address1, LocalDate.of(1998, 9, 23),
                address1, shoppingcart1);
        manufacturer1 = new Manufacturer("Apple", "mail@mail.com", "01716181447", address1);
        bracelet1 = new Bracelet("Bracelet No.1", manufacturer1, "part1", Material.ALUMINIUM,
                50, 50, 1, ConnectionType.BAND);
        casing1 = new Casing("Casing No.1", manufacturer1, "part2", Material.ALUMINIUM,
                50, 100, 2, 2, ConnectionType.BAND);
        clockwork1 = new Clockwork("Clockwork No.1", manufacturer1, "part3", Material.ALUMINIUM,
                50, 2, 2);
        bracelet2 = new Bracelet("Bracelet No.1", manufacturer1, "part1", Material.ALUMINIUM,
                120, 50, 1, ConnectionType.BAND);
        casing2 = new Casing("Casing No.1", manufacturer1, "part2", Material.ALUMINIUM,
                120, 100, 2, 2, ConnectionType.BAND);
        clockwork2 = new Clockwork("Clockwork No.1", manufacturer1, "part3", Material.ALUMINIUM,
                120, 2, 2);
        watch1 = new Watch("WatchName", "Flexing", bracelet1, casing1, clockwork1);
        watch2 = new Watch("Watch2Name", "Flexing2", bracelet2, casing2, clockwork2);
        shoppingcart1 = new Shoppingcart();
    }

    @Test
    public void should_return_zero_as_total_for_new_shoppingcart() {
        //Given
        // When
        //Then
        assertEquals(0.0, shoppingcart1.getTotal());
    }

    @Test
    public void should_add_a_watch_to_shoppingcart() {
        //Given
        // When
        shoppingcart1.addWatch(watch1);
        //Then
        List<Watch> list = shoppingcart1.getItems();    // Extra steps for showing/testing used DataType
        boolean foundWatch = list.contains(watch1);
        assertTrue(foundWatch);
    }


    @Test
    public void should_remove_a_watch_from_shoppingcart() {
        //Given
        shoppingcart1.addWatch(watch1);
        // When
        shoppingcart1.removeWatch(watch1);
        //Then
        List<Watch> list = shoppingcart1.getItems();
        boolean foundWatch = false;
        if (!list.isEmpty()) // Empty shoppingcart means no watches anyway
        {
            foundWatch = list.contains(watch1);
        }
        assertFalse(foundWatch);
    }

    @Test
    public void should_remove_only_one_of_multiple_identical_watches_from_shoppingcart() {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        // When
        shoppingcart1.removeWatch(watch1);    // Remove only one occurance of given watch
        //Then
        assertTrue(shoppingcart1.getItems().contains(watch1));    // Shoppingcart should still have one of those watches left
    }

    @Test
    public void should_remove_all_occurrences_of_given_watch_from_shoppingcart() {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        // When
        shoppingcart1.removeAllOccurrencesOfWatch(watch1);
        //Then
        List<Watch> list = shoppingcart1.getItems();
        boolean foundWatch = false;
        if (!list.isEmpty())     // Empty shoppingcart means no watches anyway
        {
            foundWatch = list.contains(watch1);
        }
        assertFalse(foundWatch);
    }

    @Test
    public void should_remove_the_two_occurrences_of_given_watch_from_shoppingcart() {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        // When
        int occurances = shoppingcart1.removeAllOccurrencesOfWatch(watch1);    // Count how many Occurances were removed
        //Then
        assertEquals(2, occurances);
    }

    @Test
    public void should_return_165_as_new_total_for_shoppingcart() throws WatchNameNotValidException {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        // When
        shoppingcart1.removeWatch(watch1);   // One watch1 should be remaining
        //Then
        assertEquals(165, shoppingcart1.getTotal());
    }

    @Test
    public void should_return_zero_as_new_total_for_shoppingcart() throws WatchNameNotValidException {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        // When
        shoppingcart1.removeAllOccurrencesOfWatch(watch1);    // Shoppingcart is empty afterwards
        //Then
        assertEquals(0.0, shoppingcart1.getTotal());
    }

    @Test
    public void should_return_330_as_new_total_for_shoppingcart() throws WatchNameNotValidException {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch2);
        // When
        shoppingcart1.removeWatch(watch2);   // Two Occurances of watch1 remaining
        //Then
        assertEquals(330, shoppingcart1.getTotal());
    }

    @Test
    public void should_return_396_as_new_total_for_shoppingcart() throws WatchNameNotValidException {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch2);
        // When
        shoppingcart1.removeAllOccurrencesOfWatch(watch1);    // Only Expensive watch2 should be remaining
        //Then
        assertEquals(396.0, shoppingcart1.getTotal());
    }

    @Test
    public void should_return_561_as_new_total_for_shoppingcart() throws WatchNameNotValidException {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch2);  // More expensive Watch
        // When
        shoppingcart1.removeWatch(watch1);   // one watch2 and one watch1 should be remaining
        //Then
        assertEquals(561.0, shoppingcart1.getTotal());
    }

    @Test
    public void should_empty_shoppingcart_completely() {
        //Given
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        // When
        shoppingcart1.clear();
        //Then
        assertTrue(shoppingcart1.getItems().isEmpty());
    }

    @Test
    public void should_return_zero_as_total_after_clearing_shoppingcart() {
        //Given
        shoppingcart1.addWatch(watch1);   // Add a couple of watches
        shoppingcart1.addWatch(watch1);
        shoppingcart1.addWatch(watch1);
        // When
        shoppingcart1.clear();   // Resetting Shoppingcart
        //Then
        assertEquals(0.0, shoppingcart1.getTotal());
    }
}
