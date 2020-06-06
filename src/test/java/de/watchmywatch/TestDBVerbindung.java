package de.watchmywatch;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.repository.exception.JpaStorageController;
import de.watchmywatch.repository.exception.StorageException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDBVerbindung {
    private Address address;
    private Customer customer;
    JpaStorageController controller;

    @BeforeEach
    void SetSomeCustomer(){
        address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", new Date(1998, Calendar.SEPTEMBER, 23));
        controller= new  JpaStorageController();

    }

    @Test
    void controller_should_add_a_Data_line_into_Cutomer_table() throws StorageException
    {

        controller.saveCustomer(customer);
        //ab = controller.loadAddressbook();

        //assertEquals(3,ab.getSize());

    }


}
