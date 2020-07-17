package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * class which tests the functionality of Watch
 */

public class TestWatch {
    // create some reusable objects
    Address address1;
    User user1;
    Manufacturer manufacturer1;
    Bracelet bracelet1;
    Casing casing1;
    Clockwork clockwork1;
    Bracelet bracelet2;
    Watch watch1;
    Watch watch2;
    Shoppingcart shoppingcart1;

    @BeforeEach
    void setUp() {
        address1 = new Address("street 2", "city", "state", "012345");
        shoppingcart1 = new Shoppingcart();
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
                2000, 50, 1, ConnectionType.BAND);
        watch1 = new Watch("WatchName", "Flexing", bracelet1, casing1, clockwork1);
        watch2 = new Watch("Watch2Name", "Flexing2", bracelet2, casing1, clockwork1);
    }

    private String create141characterString() {
        String string = "";
        for (int i = 0; i < 141; ++i) {
            string += "a";
        }
        return string;
    }

    @Test
    public void should_create_a_valid_watch() throws WatchNameNotValidException {
        //Given
        // When
        //Then
        assertEquals(true, watch1.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_with_no_parts() throws WatchNameNotValidException {
        //Given
        //When
        Watch nonValidWatch = new Watch("Swatch", "Test");
        //Then
        assertEquals(false, nonValidWatch.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_smaller_zero_without_fee() throws WatchNameNotValidException {
        //Given
        //When
        watch1.getClockwork().setPrice(-400);
        //Then
        assertEquals(false, watch1.validate());
    }

    @Test
    public void should_create_a_non_valid_watch_price_equal_zero_without_fee() throws WatchNameNotValidException {
        //Given
        //When
        watch1.getClockwork().setPrice(-150);
        //Then
        assertEquals(false, watch1.validate());
    }

    @Test
    public void should_check_fee_calculation_for_under_2000euro() throws WatchNameNotValidException {
        //Given
        //When
        //Then
        assertEquals(165.00, watch1.getPriceWithFee());
    }

    @Test
    public void should_check_fee_calculation_for_over_2000euro() throws WatchNameNotValidException {
        //Given
        //When
        //Then
        assertEquals(2300.0, watch2.getPriceWithFee());
    }
}
