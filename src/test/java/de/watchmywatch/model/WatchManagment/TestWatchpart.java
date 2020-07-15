package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * class which tests the functionality of Watchparts: Bracelet, Casing and Clockwork
 */
public class TestWatchpart {
    //create some reusable objects
    Address address = new Address("street", "city", "state", "zip");
    Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23)), address);

    @Test
    public void should_create_a_valid_casing() {
        //Given
        // When
        Casing casing = new Casing("Casing No.1", manufacturer, "id", Material.ALUMINIUM, 1.00, 100, 2.00, 2.00, ConnectionType.BAND);
        //Then
        assertEquals(true, casing.validate());
    }

    @Test
    public void should_create_a_non_valid_casing() {
        //Given
        //When
        Casing casing = new Casing("Casing No.1", manufacturer, "id", Material.ALUMINIUM, -1.00, 100, 2.00, 2.00, ConnectionType.BAND);
        //Then
        assertEquals(false, casing.validate());
    }

    @Test
    public void should_create_a_valid_bracelet() {
        //Given
        // When
        Bracelet bracelet = new Bracelet("Bracelet No.1", manufacturer, "ID", Material.ALUMINIUM, 2.00, 100, 2.00, ConnectionType.BAND);
        //Then
        assertEquals(true, bracelet.validate());
    }

    @Test
    public void should_create_a_non_valid_bracelet() {
        //Given
        //When
        Bracelet bracelet = new Bracelet("Bracelet No.1", manufacturer, "ID", Material.ALUMINIUM, -2.00, 100, 2.00, ConnectionType.BAND);
        //Then
        assertEquals(false, bracelet.validate());
    }

    @Test
    public void should_create_a_valid_clockwork() {
        //Given
        // When
        Clockwork clockwork = new Clockwork("Clockwork No.1", manufacturer, "ID", Material.ALUMINIUM, 2.00, 100, 2.00);
        //Then
        assertEquals(true, clockwork.validate());
    }

    @Test
    public void should_create_a_non_valid_clockwork() {
        //Given
        //When
        Clockwork clockwork = new Clockwork("Clockwork No.1", manufacturer, "ID", Material.ALUMINIUM, -1.00, 100, 2.00);
        //Then
        assertEquals(false, clockwork.validate());
    }

}
