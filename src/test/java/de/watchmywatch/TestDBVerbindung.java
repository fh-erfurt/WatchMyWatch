package de.watchmywatch;

import de.watchmywatch.model.AccountManagment.Account;
import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.repository.exception.JpaStorageController;
import de.watchmywatch.repository.exception.StorageException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static de.watchmywatch.model.AccountManagment.AccountStatus.*;
import static de.watchmywatch.model.OrderManagment.PaymentMethod.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDBVerbindung {

    private Address address;
    private Customer customer;
    private Account account;
    JpaStorageController controller;


    @BeforeEach
    void SetSomeCustomer(){
        address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", new Date(1998, Calendar.SEPTEMBER, 23));
        controller= new  JpaStorageController();
    }

    @BeforeEach
    void SetSomeAccount(){
        account = new Account( customer, "Salami", address, new Date(2020, Calendar.JANUARY, 26), PAYPAL, ACTIV,
                new Shoppingcart());
    }

    @Test
    void controller_should_add_a_Data_line_into_Cutomer_table() throws StorageException
    {

        controller.saveCustomer(customer);
        //ab = controller.loadAddressbook();

        //assertEquals(3,ab.getSize());

    }

    @Test
    void controller_should_add_a_Data_line_into_Account_table() throws StorageException
    {

        controller.saveAccount(account);
        //ab = controller.loadAddressbook();

        //assertEquals(3,ab.getSize());

    }

}
