package de.watchmywatch.AccountManagment;

import de.watchmywatch.Exceptions.CustomerAlreadyExistsException;
import de.watchmywatch.Exceptions.CustomerDoesNotExistException;
import de.watchmywatch.Helper.Address;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class which tests the functionality of ManagerCustomer
 *
 * @author Anton Bespalov
 */
public class TestManagerCustomer
{
    // create some reusable objects
    private Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
    private Customer customer = new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov", new Date(1998, Calendar.SEPTEMBER, 23));


    @Test
    public void adding_a_customer_to_customerList_when_the_customer_does_not_exists()
    {
        // Given
        ManagerCustomer managerCustomer = new ManagerCustomer();
        // When
        try
        {
            managerCustomer.addCustomer(customer);
        } catch (CustomerAlreadyExistsException e)
        {
            e.printStackTrace();
        }
        // Then
        assertTrue(managerCustomer.getCustomerList().contains(customer));
    }

    @Test
    public void adding_two_time_the_same_customer()
    {
        // Given
        ManagerCustomer managerCustomer = new ManagerCustomer();
        // When
        try
        {
            managerCustomer.addCustomer(customer);
            assertTrue(managerCustomer.getCustomerList().contains(customer));
        } catch (CustomerAlreadyExistsException e)
        {
            e.printStackTrace();
        }
        // Then
        Throwable exception = assertThrows(CustomerAlreadyExistsException.class, () -> managerCustomer.addCustomer(customer));
        assertEquals("Customer already Exists!", exception.getMessage());
    }

    @Test
    public void remove_a_customer_from_customerlist()
    {
        // Given
        ManagerCustomer managerCustomer = new ManagerCustomer();
        // When
        try
        {
            managerCustomer.addCustomer(customer);
        } catch (CustomerAlreadyExistsException e)
        {
            e.printStackTrace();
        }
        try
        {
            managerCustomer.removeCustomer(customer);
        } catch (CustomerDoesNotExistException ae)
        {
            ae.printStackTrace();
        }
        // Then
        assertFalse(managerCustomer.getCustomerList().contains(customer));
    }

    @Test
    public void removing_a_account_which_not_exists()
    {
        // Given
        ManagerCustomer managerCustomer = new ManagerCustomer();
        // When
        try
        {
            managerCustomer.removeCustomer(customer);
        } catch (CustomerDoesNotExistException ae)
        {
            ae.printStackTrace();
        }
        // Then
        Throwable exception = assertThrows(CustomerDoesNotExistException.class, () -> managerCustomer.removeCustomer(customer));
        assertEquals("Customer does not exist!", exception.getMessage());
    }

}
