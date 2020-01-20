package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWatch
{
    //create some reusable objects
    Manufacturer manufacturer = new Manufacturer("Apple", new Person(), 1);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 2, 2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 2, 2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 2, 2, 2);

    @Test
    public void should_create_a_valid_watch()
    {
        //Given

        // When
        Watch watch = new Watch("Swatch", 100.00, "Test", bracelet, casing, clockwork);
        //Then
        assertEquals(true, watch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_with_no_parts()
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", 100.00, "Test");
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_smaller_zero_without_fee()
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", -100.00, "Test", bracelet, casing, clockwork);
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_equal_zero_without_fee()
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", 0.00, "Test", bracelet, casing, clockwork);
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_check_fee_calculation_for_under_2000euro()
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", 100.00, "Test");
        //Then
        assertEquals(110.00, watch.getPriceWithFee());
    }

    @Test
    public void should_check_fee_calculation_for_over_2000euro()
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", 2500.00, "Test");

        //Then
        assertEquals(2700.00, watch.getPriceWithFee());
    }
}
