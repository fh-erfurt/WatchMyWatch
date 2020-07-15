package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * class which tests the functionality of ManagerWatch
 */
public class TestManagerWatch {
    //create some reusable objects
    Address address = new Address("street", "city", "state", "zip");
    Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23)), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 2, 100, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 2, 100, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 2, 100, 2);
    Watch watch = new Watch("test", "yes", bracelet, casing, clockwork);
    Watch watch2 = new Watch("test2", "yes", bracelet, casing, clockwork);

    public TestManagerWatch() throws WatchNameNotValidException {
    }

    @Test
    public void should_create_one_watch() {
        //Given
        ManagerWatch managerWatch = new ManagerWatch();
        //When
        managerWatch.addWatch(watch);
        //Then
        assertEquals(1, managerWatch.amountOfWatches());
    }

    @Test
    public void should_create_two_watches_and_delete_one() {
        //Given
        ManagerWatch managerWatch2 = new ManagerWatch();

        //When
        managerWatch2.addWatch(watch);
        managerWatch2.addWatch(watch2);
        managerWatch2.removeWatchByName("test");
        //Then
        assertEquals(1, managerWatch2.amountOfWatches());
    }
}
