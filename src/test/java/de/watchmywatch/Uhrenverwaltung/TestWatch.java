package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Exceptions.NameException;
import de.watchmywatch.Helper.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestWatch
{
    //create some reusable objects
    Address address = new Address("street", "city", "state", "zip");
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov"), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM,2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM,2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM,2, 2);

    @Test
    public void should_create_a_valid_watch() throws NameException
    {
        //Given

        // When
        Watch watch = new Watch("Swatch",  "Test", bracelet, casing, clockwork);
        //Then
        assertEquals(true, watch.validate());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "!", "\"", "§", "$", "%", "&", "/", "(", ")", "=", "?", "´", "`", "*", "+", "'", "#", ";", ",", "_", "~", "@", "€", "[", "]", "{", "}"})
    void should_throw_nameException_with_not_allowed_chars(String testString) throws NameException {
        assertThrows(NameException.class, () -> {
            Watch watch = new Watch(testString,  "Test", bracelet, casing, clockwork);
        });
    }

    @Test
    void should_throw_nameException_with_empty_name() throws NameException {
        assertThrows(NameException.class, () -> {
            Watch watch = new Watch("",  "Test", bracelet, casing, clockwork);
        });
    }

    @Test
    void should_throw_nameException_with_name_longer_140() throws NameException {
        assertThrows(NameException.class, () -> {
            Watch watch = new Watch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Test", bracelet, casing, clockwork);
        });

        //TODO create method for creating string
    }

    @Test
    public void should_create_a_non_valid_watch_with_no_parts() throws NameException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch",  "Test");
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_smaller_zero_without_fee() throws NameException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch",  "Test", bracelet, casing, clockwork);
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_equal_zero_without_fee() throws NameException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch",  "Test", bracelet, casing, clockwork);
        //Then
        assertEquals(false, watch.validate());
    }

    @Test
    public void should_check_fee_calculation_for_under_2000euro() throws NameException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch",  "Test");
        //Then
        assertEquals(110.00, watch.getPriceWithFee());
    }

    @Test
    public void should_check_fee_calculation_for_over_2000euro() throws NameException
    {
        //Given
        //When
        Watch watch = new Watch("Swatch", "Test");
        //Then
        assertEquals(2700.00, watch.getPriceWithFee());
    }
}
