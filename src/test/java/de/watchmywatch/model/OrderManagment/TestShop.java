package de.watchmywatch.model.OrderManagment;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * class which tests the integration of subsystems AccountManagement, OrderManagement and WatchManagement
 *
 * @author Michael Hopp, Tom Käppler
 */

public class TestShop {

    // create some reusable objects
    Address address1;
    User user1;
    Manufacturer manufacturer1;
    Bracelet bracelet1;
    Casing casing1;
    Clockwork clockwork1;
    Watch watch1;
    Watch watch2;
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
        watch2 = new Watch("Watch2Name", "Flexing2", bracelet1, casing1, clockwork1);
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

    public TestShop() {
    }

    /**
     * Use Case: New User wants to buy a predefined Watch.
     * User signs up at our shop, puts a predefined watch into his*her shoppingcart, checks out and we receive the payment, whereby the Order is completed.
     *
     * @author Michael Hopp
     */

    //TODO FIX we dont save a list of orders in user anymore (wrong?)
    /*
    @Test
    public void happy_path() throws ShoppingcartEmptyException {
        //Given
        //When
        // User creates new Account
        Account myAccount = new Account(

                new Customer("michael.hopp@fh-erfurt.de", myAddress, "0123456789", "Michael", "Hopp",
                        LocalDate.of(1998, 9, 23)),
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
     */


    /**
     * Use Case:
     * User signs up at our shop, puts two predefined watches into his*her shoppingcart, deletes one, checks out and we receive the payment.
     *
     * @author Tom Käppler
     */
//TODO FIX we dont save a list of orders in user anymore (wrong?)
    /*
    @Test
    public void quite_happy_path_() throws ShoppingcartEmptyException {
        //Given
        //When
        //User creates new Account
        User newUser = new User("Test", "User", "user@mail.com", "password",
                "01716181447", address1, LocalDate.of(1998, 9, 23),
                address1, shoppingcart1);
        // User puts new Watch into his*her shoppingcart
        newUser.getShoppingCart().addWatch(watch1);
        newUser.getShoppingCart().addWatch(watch2);
        // User removes one watch
        user1.getShoppingCart().removeWatch(watch1);
        // User checks out
        Order myOrder = new Order(user1.getAddress(), user1.getShoppingCart());
        myOrder.getPayment().setPaymentMethod(PaymentMethod.PAYPAL);
        user1.addOrder(myOrder);
        // User Paid oldest unpaid Order
        Order oldestUnpaidOrder = user1.getOldestUnpaidOrder();
        boolean success = oldestUnpaidOrder.pay();

        //Then
        assertTrue(success);
        assertEquals(OrderStatus.COMPLETE, oldestUnpaidOrder.getOrderStatus());
    }

 */

    /**
     * Use Case:
     * User signs up at our shop, puts one predefined watches into his*her shoppingcart, deletes one, checks out and we receive the payment.
     *
     * @author Tom Käppler
     */

    @Test
    public void not_happy_path_() {
        //Given
        //When
        // User creates new Account
        User newUser = new User("Test", "User", "user@mail.com", "password",
                "01716181447", address1, LocalDate.of(1998, 9, 23),
                address1, new Shoppingcart());
        // User puts new Watch into his*her shoppingcart
        newUser.getShoppingCart().addWatch(watch1);
        // User removes one watch
        newUser.getShoppingCart().removeWatch(watch1);
        // User checks out
        //Then
        assertThrows(ShoppingcartEmptyException.class, () ->
        {
            Order myOrder = new Order(newUser.getAddress(), newUser.getShoppingCart());
        });
    }
}
