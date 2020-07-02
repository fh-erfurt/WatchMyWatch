package de.watchmywatch.model.OrderManagment;

import de.watchmywatch.model.AccountManagment.*;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.OrderManagment.*;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * class which tests the integration of subsystems AccountManagement, OrderManagement and WatchManagement
 * @author Michael Hopp, Tom Käppler
 */
public class TestShop
{

    // create some reusable objects
    Address myAddress = new Address("Grolmannstraße 13", "Erfurt", "Germany", "99085");
    Shoppingcart myShoppingcart = new Shoppingcart();
    Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", myAddress,
            "01716181447", "Anton", "Bespalov",new Date(1998, Calendar.SEPTEMBER, 23)), myAddress);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 10000, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 15000, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 25000, 2);
    Watch testWatch1 = new Watch("Swatch1", "Test1", bracelet, casing, clockwork);
    Watch testWatch2 = new Watch("Swatch2", "Test2", bracelet, casing, clockwork);

    public TestShop() throws WatchNameNotValidException
    {
    }

    /**
     * Use Case: New User wants to buy a predefined Watch.
     * User signs up at our shop, puts a predefined watch into his*her shoppingcart, checks out and we receive the payment, whereby the Order is completed.
     * @author Michael Hopp
     */
    @Test
    public void happy_path() throws WatchNameNotValidException, ShoppingcartEmptyException
    {
    //Given
        // The desired watch
        Watch watch1 = new Watch("SweetRolex", "Attributes: +2 Handshaking, +3 Intimidation",
                bracelet, casing, clockwork);
    //When
        // User creates new Account
        Account myAccount = new Account(
                new Customer("michael.hopp@fh-erfurt.de", myAddress, "0123456789", "Michael", "Hopp",
                        new Date(1996, 9, 24)),
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


    /**
     * Use Case:
     * User signs up at our shop, puts two predefined watches into his*her shoppingcart, deletes one, checks out and we receive the payment.
     *
     * @author Tom Käppler
     */
    @Test
    public void quite_happy_path_() throws ShoppingcartEmptyException
    {
    //Given
    //When
        // User creates new Account
        Account myAccount = new Account(
                new Customer("michael.hopp@fh-erfurt.de", myAddress, "0123456789", "Michael", "Hopp",
                        new Date(1996, 9, 24)),
                "root", myAddress, new Date(), PaymentMethod.PAYPAL, AccountStatus.ACTIV, myShoppingcart);
        // User puts new Watch into his*her shoppingcart
        myAccount.getShoppingCart().addWatch(testWatch1);
        myAccount.getShoppingCart().addWatch(testWatch2);
        // User removes one watch
        myAccount.getShoppingCart().removeWatch(testWatch1);
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

    /**
     * Use Case:
     * User signs up at our shop, puts one predefined watches into his*her shoppingcart, deletes one, checks out and we receive the payment.
     *
     * @author Tom Käppler
     */
    @Test
    public void not_happy_path_()
    {
    //Given
    //When
        // User creates new Account
        Account myAccount = new Account(
                new Customer("michael.hopp@fh-erfurt.de", myAddress, "0123456789", "Michael", "Hopp",
                        new Date(1996, 9, 24)),
                "root", myAddress, new Date(), PaymentMethod.PAYPAL, AccountStatus.ACTIV, myShoppingcart);
        // User puts new Watch into his*her shoppingcart
        myAccount.getShoppingCart().addWatch(testWatch1);
        // User removes one watch
        myAccount.getShoppingCart().removeWatch(testWatch1);
        // User checks out
    //Then
        assertThrows(ShoppingcartEmptyException.class, () ->
        {
            Order myOrder = new Order(myAccount.getCustomer().getAddress(), myAccount.getShoppingCart());
        });
    }
}
