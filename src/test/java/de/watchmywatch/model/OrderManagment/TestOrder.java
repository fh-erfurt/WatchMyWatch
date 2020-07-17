package de.watchmywatch.model.OrderManagment;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class which tests the functionality of Order
 *
 * @author Michael Hopp
 */

public class TestOrder {
    // create some reusable objects
    Address address1;
    User user1;
    Manufacturer manufacturer1;
    Bracelet bracelet1;
    Casing casing1;
    Clockwork clockwork1;
    Watch watch1;
    Shoppingcart shoppingcart1;
    Order order1;

    @BeforeEach
    void setUp() {
        address1 = new Address("street 2", "city", "state", "012345");
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
        watch1 = new Watch("WatchName", "Flexing", bracelet1, casing1, clockwork1);
        shoppingcart1 = createNotEmptyShoppingcart(watch1);
        try {
            order1 = new Order(address1, shoppingcart1);
        } catch (ShoppingcartEmptyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates Shoppingcart, which won't throw ShoppingcartEmptyException.
     *
     * @param watch Watch that will be added to returned Shoppingcart
     * @return Shoppingcart object which is not empty
     */

    private Shoppingcart createNotEmptyShoppingcart(Watch watch) {
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        return shoppingcart;
    }

    @Test
    public void should_create_new_order_with_orderstatus_pending() throws ShoppingcartEmptyException {
        //Given
        OrderStatus pending = OrderStatus.PENDING;
        //When
        //Then
        assertEquals(pending, order1.getOrderStatus());
    }

    @Test
    public void should_calculate_total_with_shippingfee() throws ShoppingcartEmptyException {
        //Given
        //When
        //Then
        assertEquals(170.9, order1.getTotal()); // Price of Watch with fee should be 165 + SHIPPINGFEE(5.90)
    }

    @Test
    public void should_set_shippingDate_to_current_time_when_sent() throws ShoppingcartEmptyException {
        //Given
        //When
        order1.setShippingStatus(ShippingStatus.SENT);
        //Then
        assertTrue(order1.getShipDate() != null);
    }

    @Test
    public void should_have_paymentMethod_paypal() {
        //Given
        order1.setPayment(new Payment(PaymentMethod.PAYPAL, "tests"));
        //When
        //Then
        assertEquals(PaymentMethod.PAYPAL, order1.getPayment().getPaymentMethod());
    }

    @Test
    public void should_be_paid_if_payment_date_is_set() {
        //Given
        //When
        order1.getPayment().setDatePaid(new Date());
        //Then
        assertTrue(order1.isPaid());
    }

}
