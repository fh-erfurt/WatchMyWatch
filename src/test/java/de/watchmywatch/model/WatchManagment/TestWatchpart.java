package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * class which tests the functionality of Watchparts: Bracelet, Casing and Clockwork
 */

public class TestWatchpart {
    // create some reusable objects
    Address address1;
    Manufacturer manufacturer1;


    @BeforeEach
    void setUp() {
        address1 = new Address("street 2", "city", "state", "012345");
        manufacturer1 = new Manufacturer("Apple", "mail@mail.com", "01716181447", address1);
    }

    @Test
    public void should_create_a_valid_casing() {
        //Given
        //When
        Casing casing1 = new Casing("Casing No.1", manufacturer1, "part2", Material.ALUMINIUM,
                50, 100, 2, 2, ConnectionType.BAND);
        //Then
        assertEquals(true, casing1.validate());
    }

    @Test
    public void should_create_a_non_valid_casing() {
        //Given
        //When
        Casing nonValidCasing = new Casing("Casing No.1", manufacturer1, "part2", Material.ALUMINIUM,
                -1, 100, 2, 2, ConnectionType.BAND);
        //Then
        assertEquals(false, nonValidCasing.validate());
    }

    @Test
    public void should_create_a_valid_bracelet() {
        //Given
        // When
        Bracelet bracelet1 = new Bracelet("Bracelet No.1", manufacturer1, "part1", Material.ALUMINIUM,
                50, 50, 1, ConnectionType.BAND);
        //Then
        assertEquals(true, bracelet1.validate());
    }

    @Test
    public void should_create_a_non_valid_bracelet() {
        //Given
        //When
        Bracelet nonValidBracelet = new Bracelet("Bracelet No.1", manufacturer1, "part1", Material.ALUMINIUM,
                -1, 50, 1, ConnectionType.BAND);//Then
        assertEquals(false, nonValidBracelet.validate());
    }

    @Test
    public void should_create_a_valid_clockwork() {
        //Given
        // When
        Clockwork clockwork1 = new Clockwork("Clockwork No.1", manufacturer1, "part3", Material.ALUMINIUM,
                50, 2, 2);
        //Then
        assertEquals(true, clockwork1.validate());
    }

    @Test
    public void should_create_a_non_valid_clockwork() {
        //Given
        //When
        Clockwork nonValidClockwork = new Clockwork("Clockwork No.1", manufacturer1, "part3", Material.ALUMINIUM,
                -1, 2, 2);
        //Then
        assertEquals(false, nonValidClockwork.validate());
    }

}
