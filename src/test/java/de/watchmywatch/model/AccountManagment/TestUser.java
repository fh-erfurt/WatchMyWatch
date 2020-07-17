package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Shoppingcart;

import de.watchmywatch.model.WatchManagment.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static de.watchmywatch.model.AccountManagment.User.get_SHA_256_SecurePassword;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Class which tests the functionality of User
 *
 * @author Anton Bespalov
 */

public class TestUser {

    private Address address1;
    private Shoppingcart shoppingcart1;
    private Manufacturer manufacturer1;
    private User user1;
    private Bracelet bracelet1;
    private Casing casing1;
    private Clockwork clockwork1;
    private Watch watch1;
    private Order order1;

    @BeforeEach
    void setUp() {
        address1 = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        shoppingcart1 = new Shoppingcart();
        manufacturer1 = new Manufacturer("Apple", "mail@mail.com", "01716181447", address1);
        user1 = new User("Test", "User", "user@mail.com", "password",
                "01716181447", address1, LocalDate.of(1998, 9, 23),
                address1, shoppingcart1);
        bracelet1 = new Bracelet("Bracelet No.1", manufacturer1, "part1", Material.ALUMINIUM,
                50, 50, 1, ConnectionType.BAND);
        casing1 = new Casing("Casing No.1", manufacturer1, "part2", Material.ALUMINIUM,
                50, 100, 2, 2, ConnectionType.BAND);
        clockwork1 = new Clockwork("Clockwork No.1", manufacturer1, "part3", Material.ALUMINIUM,
                50, 2, 2);
        watch1 = new Watch("WatchName", "Flexing", bracelet1, casing1, clockwork1);
        try {
            shoppingcart1.addWatch(watch1);
            order1 = new Order(address1, shoppingcart1);
        } catch (ShoppingcartEmptyException e) {
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

    @Test
    public void get_secure_password() {
        //Given
        String securePassword = get_SHA_256_SecurePassword("Salamination");
        //When

        //Then
        assertEquals("f1aca9ab91d28dd37c4f7b3595afe26a4eec88c138b0fac8bbeb6062d88df126", securePassword);
    }

    @Test
    public void change_password() {
        //Given
        String newPassword = "VBGHJKOPOIU";
        //When
        user1.changePassword(newPassword);
        //Then
        assertEquals("667558aa1d5b1f761a62cfabac2b6277d9be028dfe4ff296e966d4b39cd387cf", user1.getSecurePassword());
    }

    @Test
    public void add_order1_to_order1_list() {
        //Given
        boolean result = user1.addOrder(order1);
        //When

        //Then
        assertTrue(result);
    }

    @Test
    public void remove_order1_from_order1_list() {
        //Given
        user1.addOrder(order1);
        boolean result = user1.removeOrder(order1);

        //When

        //Then
        assertTrue(result);
    }

    @Test
    public void should_return_oldest_of_two_unpaid_order1s_with_correct_OrderDate() throws ShoppingcartEmptyException {
        // Given
        Order order2 = new Order(address1, shoppingcart1);
        //LocalDateTime date = LocalDateTime.of(2000, Month.JANUARY, 1, 12, 0);
        Date date = new Date(20000102);
        order2.setOrderDate(date);
        user1.addOrder(order1);
        user1.addOrder(order2);
        // When

        // Then
        assertFalse(user1.getOldestUnpaidOrder().isPaid());
        assertEquals(date, user1.getOldestUnpaidOrder().getOrderDate());
    }

    @Test
    public void should_return_oldest_of_three_order1s_where_two_are_unpaid_with_correct_OrderDate() throws ShoppingcartEmptyException {
        // Given
        Order order12 = new Order(address1, shoppingcart1);
        //LocalDateTime date = LocalDateTime.of(2000, Month.JANUARY, 1, 12, 0);
        Date date = new Date(20000102);
        order12.setOrderDate(date);
        Order order13 = order1;
        order13.getPayment().setDatePaid(new Date());
        user1.addOrder(order1);
        user1.addOrder(order12);
        // When

        // Then
        assertFalse(user1.getOldestUnpaidOrder().isPaid());
        assertEquals(date, user1.getOldestUnpaidOrder().getOrderDate());
    }
}
