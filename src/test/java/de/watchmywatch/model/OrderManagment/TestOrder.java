package de.watchmywatch.model.OrderManagment;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
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
    Address address = new Address("street 2", "city", "state", "012345");
    Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", new Address("Lilo-Herrmann-Straße 2",
            "Erfurt", "Thüringen", "99086"), "01716181447", "Anton", "Bespalov", LocalDate.of(1998, 9, 23)), address);
    private Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 25, 100, 1, ConnectionType.BAND);
    private Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 25, 100, 2, 2, ConnectionType.BAND);
    private Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 50, 100, 2);
    private Watch watch = new Watch("Swatch", "Test", bracelet, casing, clockwork);

    private Shoppingcart shoppingcart = createNotEmptyShoppingcart(watch);
    private Order testOrder = new Order(address, shoppingcart);

    public TestOrder() throws WatchNameNotValidException, ShoppingcartEmptyException {
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
        Order order = new Order(address, shoppingcart);
        OrderStatus pending = OrderStatus.PENDING;
        // When

        //Then
        assertEquals(pending, order.getOrderStatus());
    }

    @Test
    public void should_calculate_total_with_shippingfee() throws ShoppingcartEmptyException {
        //Given
        Order order = new Order(address, shoppingcart);
        // When

        //Then
        assertEquals(115.90, order.getTotal()); // Price of Watch with fee should be 110 + SHIPPINGFEE(5.90)
    }

    @Test
    public void should_set_shippingDate_to_current_time_when_sent() throws ShoppingcartEmptyException {
        //Given
        Order order = new Order(address, shoppingcart);
        // When
        order.setShippingStatus(ShippingStatus.SENT);
        //Then
        assertTrue(order.getShipDate() != null);
    }

    @Test
    public void should_have_paymentMethod_paypal() {
        //Given
        testOrder.setPayment(new Payment(PaymentMethod.PAYPAL, "tests"));
        // When

        //Then
        assertEquals(PaymentMethod.PAYPAL, testOrder.getPayment().getPaymentMethod());
    }

    @Test
    public void should_be_paid_if_payment_date_is_set() {
        //Given

        // When
        testOrder.getPayment().setDatePaid(new Date());
        //Then
        assertTrue(testOrder.isPaid());
    }

}
