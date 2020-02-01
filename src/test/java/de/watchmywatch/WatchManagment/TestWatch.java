package de.watchmywatch.WatchManagment;

import de.watchmywatch.AccountManagment.Person;
import de.watchmywatch.Exceptions.WatchNameNotValidException;
import de.watchmywatch.Helper.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * class which tests the functionality of Watch
 */
public class TestWatch
{
    //create some reusable objects
    Address address = new Address("street", "city", "state", "zip");
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 2, 2);

    private String create141characterString()
    {
        String string = "";
        for (int i = 0; i < 141; ++i)
        {
            string += "a";
        }
        return string;
    }

    @Test
    public void should_create_a_valid_watch() throws WatchNameNotValidException
    {
        //Given

        // When
        Watch watch = new Watch("Swatch", "Test", bracelet, casing, clockwork);
        //Then
        assertEquals(true, watch.validate());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "!", "\"", "§", "$", "%", "&", "/", "(", ")", "=", "?", "´", "`", "*", "+", "'", "#", ";", ",", "_", "~", "@", "€", "[", "]", "{", "}"})
    void should_throw_nameException_with_not_allowed_chars(String testString) throws WatchNameNotValidException
    {
        assertThrows(WatchNameNotValidException.class, () ->
        {
            Watch watch = new Watch(testString, "Test", bracelet, casing, clockwork);
        });
    }

    @Test
    void should_throw_nameException_with_empty_name() throws WatchNameNotValidException
    {
        assertThrows(WatchNameNotValidException.class, () ->
        {
            Watch watch = new Watch("", "Test", bracelet, casing, clockwork);
        });
    }

    @Test
    void should_throw_nameException_with_name_longer_140() throws WatchNameNotValidException
    {
        assertThrows(WatchNameNotValidException.class, () ->
        {
            Watch watch = new Watch(create141characterString(), "Test", bracelet, casing, clockwork);
        });
    }

    @Test
    public void should_create_a_non_valid_watch_with_no_parts() throws WatchNameNotValidException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", "Test");
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_smaller_zero_without_fee() throws WatchNameNotValidException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", "Test", new Bracelet(manufacturer, "part1", Material.ALUMINIUM, -200, 1, ConnectionType.BAND), casing, clockwork);
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_equal_zero_without_fee() throws WatchNameNotValidException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", "Test", new Bracelet(manufacturer, "part1", Material.ALUMINIUM, -4, 1, ConnectionType.BAND), casing, clockwork);
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_check_fee_calculation_for_under_2000euro() throws WatchNameNotValidException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", "Test");
        watch.setPrice(100.00);
        //Then
        assertEquals(110.00, watch.getPriceWithFee());
    }

    @Test
    public void should_check_fee_calculation_for_over_2000euro() throws WatchNameNotValidException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", "Test");
        watch.setPrice(2500.00);
        //Then
        assertEquals(2700.00, watch.getPriceWithFee());
    }
}
