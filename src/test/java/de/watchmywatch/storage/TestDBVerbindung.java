package de.watchmywatch.storage;

import de.watchmywatch.model.AccountManagment.Account;
import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.model.WatchManagment.*;
import de.watchmywatch.repository.exception.JpaStorageController;
import de.watchmywatch.repository.exception.StorageException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static de.watchmywatch.model.AccountManagment.AccountStatus.*;
import static de.watchmywatch.model.OrderManagment.PaymentMethod.*;

public class TestDBVerbindung {

    private Address address;
    private Customer customer;
    private Account account;
    JpaStorageController controller;
    Order myOrder;
    Watch watch1;
    Bracelet bracelet;
    Casing casing;
    Clockwork clockwork;
    Manufacturer manufacturer;


    @BeforeEach
    void SetSomeData() throws ShoppingcartEmptyException, WatchNameNotValidException {
        address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", new Date(1998, Calendar.SEPTEMBER, 23));
        controller= new  JpaStorageController();

         manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", address,
                "01716181447", "Anton", "Bespalov",new Date(1998, Calendar.SEPTEMBER, 23)), address);
         bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 10000, 1, ConnectionType.BAND);
         casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 15000, 2, 2, ConnectionType.BAND);
         clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 25000, 2);

        watch1 = new Watch("SweetRolex", "Attributes: +2 Handshaking, +3 Intimidation",
                bracelet, casing, clockwork);
        account = new Account( customer, "Salami", address, new Date(2020, Calendar.JANUARY, 26), PAYPAL, ACTIV, new Shoppingcart());

    }


    @Test
    void controller_should_add_a_Data_line_into_Cutomer_table() throws StorageException
    {

        controller.saveCustomer(customer);
        //ab = controller.loadAddressbook();

        //assertEquals(3,ab.getSize());

    }

    @Test
    void controller_should_add_a_Data_line_into_Account_table() throws StorageException {


        controller.saveAccount(account);
        //ab = controller.loadAddressbook();

        //assertEquals(3,ab.getSize());

    }

    @Test
    void controller_should_add_a_Data_line_into_Order_table() throws StorageException, ShoppingcartEmptyException {
        account.getShoppingCart().addWatch(watch1);

        myOrder = new Order(address,account.getShoppingCart() );
        controller.saveOrder(myOrder);
        //ab = controller.loadAddressbook();

        //assertEquals(3,ab.getSize());

    }

}
