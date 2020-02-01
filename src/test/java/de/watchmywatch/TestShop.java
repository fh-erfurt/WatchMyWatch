package de.watchmywatch;

import de.watchmywatch.AccountManagment.Account;
import de.watchmywatch.AccountManagment.AccountStatus;
import de.watchmywatch.AccountManagment.Customer;
import de.watchmywatch.AccountManagment.Person;
import de.watchmywatch.OrderManagment.Order;
import de.watchmywatch.OrderManagment.OrderStatus;
import de.watchmywatch.OrderManagment.PaymentMethod;
import de.watchmywatch.OrderManagment.Shoppingcart;
import de.watchmywatch.Exceptions.WatchNameNotValidException;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.WatchManagment.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration Tests
 * @author Michael Hopp, ...
 */
public class TestShop
{
    // create some reusable objects
    Address myAddress = new Address("Grolmannstraße 13","Erfurt", "Germany", "99085");
    Shoppingcart myShoppingcart = new Shoppingcart();
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", myAddress,
            "01716181447", "Anton", "Bespalov"), myAddress);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM,10000, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM,15000, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM,25000, 2);
    Watch watch = new Watch("Swatch","Test", bracelet, casing, clockwork);

    public TestShop() throws WatchNameNotValidException
    {
    }

    /**
     * Use Case:
     * User signs up at our shop, puts a predefined watch into his*her shoppingcart, checks out and we receive the payment.
     * @author Michael Hopp
     */
    @Test
    public void happy_path() throws WatchNameNotValidException
    {
    //Given
        // The desired watch
        Watch watch1 = new Watch("SweetRolex", "Attributes: +2 Handshaking, +3 Intimidation",
                bracelet, casing, clockwork);
    //When
        // User creates new Account
        Account myAccount = new Account(
                new Customer("michael.hopp@fh-erfurt.de", myAddress,"0123456789", "Michael" , "Hopp",
                new Date(1996,9,24)),
                "root", myAddress, new Date(), PaymentMethod.PAYPAL, AccountStatus.ACTIV, myShoppingcart);
        // User puts new Watch into his*her shoppingcart
        myAccount.getShoppingCart().addWatch(watch1);
        // User checks out
        Order myOrder = new Order(myAccount.getCustomer().getAddress(), myAccount.getShoppingCart());
        myOrder.getPayment().setPaymentMethod(PaymentMethod.PAYPAL);
        myAccount.addOrder(myOrder);
        // User Paid oldest unpaid Order
        Order oldestUnpaidOrder = myAccount.getOldestUnpaidOrder();
        boolean success = oldestUnpaidOrder.pay();

    //Then
        assertTrue(success);
        assertEquals(OrderStatus.COMPLETE, oldestUnpaidOrder.getOrderStatus());
    }
}
