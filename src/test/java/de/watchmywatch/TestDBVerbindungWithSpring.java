package de.watchmywatch;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.repository.storage.CustomerRepository;
import de.watchmywatch.repository.storage.CustomerController;
import de.watchmywatch.repository.exception.StorageException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

public class TestDBVerbindungWithSpring<args> {
    private Address address;
    private Customer customer;
    @Autowired
    private CustomerController mc;
    CustomerRepository repository;

    @BeforeEach
    void SetSomeData() {
        address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", new Date(1998, Calendar.SEPTEMBER, 23));
        mc = new CustomerController();
    }

    @Test
    void controller_should_add_a_Data_line_into_Cutomer_table() throws StorageException {



    }

}
