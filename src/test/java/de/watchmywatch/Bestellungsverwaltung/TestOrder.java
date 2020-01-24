package de.watchmywatch.Bestellungsverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.Uhrenverwaltung.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: Lagerbestand nach Bestellung aktualisieren.
public class TestOrder
{
    // create some reusable objects
    Address address = new Address("Lilo-Herrmann-Straße","Erfurt", "Thüringen", "99086");
    Manufacturer manufacturer = new Manufacturer("Apple",  new Person("anton.bespalov@fh-erfurt.de", address,
            "01716181447", "Anton", "Bespalov"), address);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 2, 2, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 2, 2, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 2, 2, 2);
    Watch watch = new Watch("Swatch", 100.00, "Test", bracelet, casing, clockwork);
    Shoppingcart shoppingcart = new Shoppingcart();

    Order testOrder = new Order(address, shoppingcart);
    @Test
    public void should_create_new_order_with_orderstatus_pending()
    {
        //Given
        Order order = new Order(address, shoppingcart);
        OrderStatus pending = OrderStatus.PENDING;
        // When

        //Then
        assertEquals(pending, order.getOrderStatus());
    }

    @Test
    public void should_calculate_total_with_shippingfee()
    {
        //Given
        Order order = new Order(address, shoppingcart);
        order.getShoppingcart().addWatch(watch);   // Price with fee: 110
        // When

        //Then
        assertEquals(115.90, order.getTotal());
    }

    @Test
    public void should_set_shippingDate_to_current_time_when_sent()
    {
        //Given
        Order order = new Order(address, shoppingcart);
        // When
        order.setShippingStatus(ShippingStatus.SENT);
        LocalDateTime date = LocalDateTime.now();
        //Then
        assertEquals(date, order.getShipDate());
    }

    @Test
    public void should_have_paymentMethod_paypal()
    {
        //Given
        testOrder.setPayment(new Payment(PaymentMethod.PAYPAL,"tests"));
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
