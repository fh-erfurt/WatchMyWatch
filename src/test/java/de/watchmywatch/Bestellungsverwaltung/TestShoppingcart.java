package de.watchmywatch.Bestellungsverwaltung;
import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.Uhrenverwaltung.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShoppingcart
{
    // create some reusable objects
    Address address = new Address("Lilo-Herrmann-Straße","Erfurt", "Thüringen", "99086");
    Manufacturer manufacturer = new Manufacturer("Apple",  new Person("anton.bespalov@fh-erfurt.de", address,
            "01716181447", "Anton", "Bespalov"), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 2, 2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 2, 2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 2, 2, 2);
    Watch watch = new Watch("Swatch", 100.00, "Test", bracelet, casing, clockwork);

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
        List<Watch> list = shoppingcart.getItems();
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
        List<Watch> list = shoppingcart.getItems();
        boolean foundWatch = false;
        if(!list.isEmpty())
        {
            foundWatch = list.contains(watch);
        }
        assertEquals( false , foundWatch);
    }

}
