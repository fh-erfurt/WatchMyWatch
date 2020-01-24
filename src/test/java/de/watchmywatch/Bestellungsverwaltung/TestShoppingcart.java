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
    Shoppingcart shoppingcart = new Shoppingcart();
    Address address = new Address("s","s","s", "2");
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("mail", address, "2", "fist","last"), 1);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 2, 2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 2, 2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 2, 2, 2);
    Watch watch = new Watch("Swatch", 100.00, "Test", bracelet, casing, clockwork);

    @Test
    public void should_return_zero_as_total_for_new_shoppingcart()
    {
    //Given

    // When

    //Then
        assertEquals( 0.0 , shoppingcart.getTotal());
    }

    @Test
    public void should_add_a_watch_to_shoppingcart()
    {
    //Given

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
        Shoppingcart shoppingcart1 = new Shoppingcart();
        shoppingcart1.addWatch(watch);
    // When
        shoppingcart1.removeWatch(watch);
    //Then
        List<Watch> list = shoppingcart1.getItems();
        boolean foundWatch = false;
        if(!list.isEmpty())
        {
            foundWatch = list.contains(watch);
        }
        assertEquals( false , foundWatch);
    }

}
