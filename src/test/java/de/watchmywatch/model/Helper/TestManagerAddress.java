package de.watchmywatch.model.Helper;

import de.watchmywatch.model.Exceptions.AddressAlreadyExistsException;
import de.watchmywatch.model.Exceptions.AddressDoesNotExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class which tests the functionality of ManagerAddress
 * @author  Anton Bespalov
 */
public class TestManagerAddress
{
    private ManagerAddress managerAddress = new ManagerAddress();
    private Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");

    @Test
    public void adding_a_address_to_addressList_when_address_does_not_exists()
    {
        try
        {
            managerAddress.addAddress(address);
        }
        catch (AddressAlreadyExistsException e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void adding_two_time_the_same_address()
    {
        try
        {
            managerAddress.addAddress(address);
            assertTrue(managerAddress.getAddressList().contains(address));
        }
        catch (AddressAlreadyExistsException e)
        {
            e.printStackTrace();
        }

        Throwable exception = assertThrows(AddressAlreadyExistsException.class, () -> managerAddress.addAddress(address));
        assertEquals("Address already Exists!", exception.getMessage());
    }

    @Test
    public void remove_a_account_from_account_list()
    {
        try
        {
            managerAddress.addAddress(address);
        }
        catch (AddressAlreadyExistsException e)
        {
            e.printStackTrace();
        }
        try
        {
            managerAddress.removeAddress(address);
        }
        catch (AddressDoesNotExistsException ae)
        {
            ae.printStackTrace();
        }
    }

    @Test
    public void removing_a_account_which_not_exists()
    {
        try
        {
            managerAddress.removeAddress(address);
        }
        catch (AddressDoesNotExistsException ae)
        {
            ae.printStackTrace();
        }
        Throwable exception = assertThrows(AddressDoesNotExistsException.class, () -> managerAddress.removeAddress(address));
        assertEquals("Address does not exist!", exception.getMessage());
    }

}
