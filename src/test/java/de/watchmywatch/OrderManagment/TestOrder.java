package de.watchmywatch.OrderManagment;

import de.watchmywatch.AccountManagment.Person;
import de.watchmywatch.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.Exceptions.WatchNameNotValidException;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.WatchManagment.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Michael Hopp
 */
public class TestOrder
{
    // create some reusable objects
    private Address address = new Address("street 2", "city", "state", "012345");
    private Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", address,
            "01716181447", "Anton", "Bespalov"), address);
    private Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 25, 1, ConnectionType.BAND);
    private Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 25, 2, 2, ConnectionType.BAND);
    private Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 50, 2);
    private Watch watch = new Watch("Swatch", "Test", bracelet, casing, clockwork);

    private Shoppingcart shoppingcart = createNotEmptyShoppingcart(watch);
    private Order testOrder = new Order(address, shoppingcart);

    public TestOrder() throws WatchNameNotValidException, ShoppingcartEmptyException
    {
    }

    private Shoppingcart createNotEmptyShoppingcart(Watch watch)
    {
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.addWatch(watch);
        return shoppingcart;
    }

    @Test
    public void should_create_new_order_with_orderstatus_pending() throws ShoppingcartEmptyException
    {
        //Given
        Order order = new Order(address, shoppingcart);
        OrderStatus pending = OrderStatus.PENDING;
        // When

        //Then
        assertEquals(pending, order.getOrderStatus());
    }

    @Test
    public void should_calculate_total_with_shippingfee() throws ShoppingcartEmptyException
    {
        //Given
        Order order = new Order(address, shoppingcart);
        // When

        //Then
        assertEquals(115.90, order.getTotal()); // Price of Watch with fee should be 110 + SHIPPINGFEE(5.90)
    }

    @Test
    public void should_set_shippingDate_to_current_time_when_sent() throws ShoppingcartEmptyException
    {
        //Given
        Order order = new Order(address, shoppingcart);
        // When
        order.setShippingStatus(ShippingStatus.SENT);
        //Then
        assertTrue(order.getShipDate() != null);
    }

    @Test
    public void should_have_paymentMethod_paypal()
    {
        //Given
        testOrder.setPayment(new Payment(PaymentMethod.PAYPAL, "tests"));
        // When

        //Then
        assertEquals(PaymentMethod.PAYPAL, testOrder.getPayment().getPaymentMethod());
    }

    @Test
    public void should_be_paid_if_payment_date_is_set()
    {
        //Given

        // When
        testOrder.getPayment().setDatePaid(LocalDateTime.now());
        //Then
        assertTrue(testOrder.isPaid());
    }

}