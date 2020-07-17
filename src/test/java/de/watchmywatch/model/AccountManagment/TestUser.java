package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class which tests the functionality of User
 *
 * @author Anton Bespalov
 */

public class TestUser {

    private Address address1;
    private Shoppingcart shoppingcart1;
    private User user1;
    private Order order1;

    @BeforeEach
    void setUp() {
        address1 = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        shoppingcart1 = new Shoppingcart();
        user1 = new User("Test", "User", "user@mail.com", "password",
                "01716181447", address1, LocalDate.of(1998, 9, 23),
                address1, shoppingcart1);
        try {
            order1 = new Order(address1, shoppingcart1);
        }
        catch (ShoppingcartEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_create_a_User_with_correct_email() {
        assertEquals("user@mail.com", user1.getEmail());
    }

    @Test
    void should_create_a_Person_with_phone() {
        assertEquals("01716181447", user1.getPhone());
    }
}
