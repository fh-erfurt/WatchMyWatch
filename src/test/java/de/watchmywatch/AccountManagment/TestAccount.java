package de.watchmywatch.AccountManagment;

import de.watchmywatch.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.OrderManagment.Order;
import de.watchmywatch.OrderManagment.Shoppingcart;
import de.watchmywatch.Helper.Address;
import org.junit.Test;

import static de.watchmywatch.AccountManagment.AccountStatus.ACTIV;
import static de.watchmywatch.OrderManagment.PaymentMethod.PAYPAL;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import static de.watchmywatch.AccountManagment.Account.get_SHA_256_SecurePassword;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class which tests the functionality of Account
 * @author  Anton Bespalov
 */
public class TestAccount
{
    // create some reusable objects
    private Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
    private Account account = new Account(new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov",
            new Date(1998, Calendar.SEPTEMBER, 23)), "Salami", address, new Date(2020, Calendar.JANUARY, 26), PAYPAL, ACTIV,
            new Shoppingcart());
    private Shoppingcart shoppingcart = new Shoppingcart();
    private Order order = new Order(address, shoppingcart);

    public TestAccount() throws ShoppingcartEmptyException
    {
    }

    @Test
    public void get_secure_password()
    {
        //Given
        String securePassword = get_SHA_256_SecurePassword("Salamination");
        //When

        //Then
        assertEquals("f1aca9ab91d28dd37c4f7b3595afe26a4eec88c138b0fac8bbeb6062d88df126", securePassword);
    }
//TEST
    @Test
    public void change_password()
    {
        //Given
        String newPassword = "VBGHJKOPOIU";
        //When
        account.changePassword(newPassword);
        //Then
        assertEquals("667558aa1d5b1f761a62cfabac2b6277d9be028dfe4ff296e966d4b39cd387cf", account.getSecurePassword());
    }

    @Test
    public void add_order_to_order_list()
    {
        //Given
        boolean result = account.addOrder(order);
        //When

        //Then
        assertTrue(result);
    }

    @Test
    public void remove_order_from_order_list()
    {
        //Given
        account.addOrder(order);
        boolean result = account.removeOrder(order);

        //When

        //Then
        assertTrue(result);
    }

    @Test
    public void should_return_oldest_of_two_unpaid_orders_with_correct_OrderDate() throws ShoppingcartEmptyException
    {
        // Given
        Order order2 = new Order(address, shoppingcart);
        LocalDateTime date = LocalDateTime.of(2000, Month.JANUARY, 1, 12, 0);
        order2.setOrderDate(date);
        account.addOrder(order);
        account.addOrder(order2);
        // When

        // Then
        assertFalse(account.getOldestUnpaidOrder().isPaid());
        assertEquals(date, account.getOldestUnpaidOrder().getOrderDate());
    }

    @Test
    public void should_return_oldest_of_three_orders_where_two_are_unpaid_with_correct_OrderDate() throws ShoppingcartEmptyException
    {
        // Given
        Order order2 = new Order(address, shoppingcart);
        LocalDateTime date = LocalDateTime.of(2000, Month.JANUARY, 1, 12, 0);
        order2.setOrderDate(date);
        Order order3 = order;
        order3.getPayment().setDatePaid(LocalDateTime.now());
        account.addOrder(order);
        account.addOrder(order2);
        // When

        // Then
        assertFalse(account.getOldestUnpaidOrder().isPaid());
        assertEquals(date, account.getOldestUnpaidOrder().getOrderDate());
    }
}
