package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Exceptions.WatchNameException;
import de.watchmywatch.Helper.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManagerWatch
{
    //create some reusable objects
    Address address = new Address("street", "city", "state", "zip");
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 2, 2);
    Watch watch = new Watch("test", "yes", bracelet, casing, clockwork);
    Watch watch2 = new Watch("test2", "yes", bracelet, casing, clockwork);

    public TestManagerWatch() throws WatchNameException
    {
    }

    @Test
    public void should_create_one_watch()
    {
        //Given
        ManagerWatch managerWatch = new ManagerWatch();
        //When
        managerWatch.addWatch(watch);
        //Then
        assertEquals(1, managerWatch.amountOfWatches());
    }

    @Test
    public void should_create_two_watches_and_delete_one()
    {
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
