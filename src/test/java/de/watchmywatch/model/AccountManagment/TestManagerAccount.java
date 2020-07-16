package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.model.Exceptions.AccountAlreadyExistsException;
import de.watchmywatch.model.Exceptions.AccountDoesNotExistsException;
import de.watchmywatch.model.Helper.Address;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static de.watchmywatch.model.AccountManagment.AccountStatus.*;
import static de.watchmywatch.model.OrderManagment.PaymentMethod.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class which tests the functionality of ManagerAccount
 * @author  Anton Bespalov
 */
/*
public class TestManagerAccount
{
    // create some reusable objects
    private Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
    private Account account = new Account(new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov",
            LocalDate.of(1998, 9, 23)), "Salami", address, new Date(2020, Calendar.JANUARY, 26), PAYPAL, ACTIV,
            new Shoppingcart());


    @Test
    public void adding_a_account_to_accountList_when_account_does_not_exists_in_the_list()
    {
        // Given
        ManagerAccount managerAccount = new ManagerAccount();
        // When
        try
        {
            managerAccount.addAccount(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // Then
        assertTrue(managerAccount.getAccountList().contains(account));
    }

    @Test
    public void adding_two_time_the_same_account()
    {
        // Given
        ManagerAccount managerAccount = new ManagerAccount();
        // When
        try
        {
            managerAccount.addAccount(account);
            assertTrue(managerAccount.getAccountList().contains(account));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // Then
        Throwable exception = assertThrows(AccountAlreadyExistsException.class, () -> managerAccount.addAccount(account));
        assertEquals("Account already Exists!", exception.getMessage());
    }

    @Test
    public void remove_a_account_from_account_list()
    {
        // Given
        ManagerAccount managerAccount = new ManagerAccount();
        // When
        try
        {
            managerAccount.addAccount(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            managerAccount.removeAccount(account);
        }
        catch (AccountDoesNotExistsException ae)
        {
            ae.printStackTrace();
        }
        // Then
       assertFalse(managerAccount.getAccountList().contains(account));
    }

    @Test
    public void removing_a_account_which_not_exists()
    {
        // Given
        ManagerAccount managerAccount = new ManagerAccount();
        // When
        try
        {
            managerAccount.removeAccount(account);
        }
        catch (AccountDoesNotExistsException ae)
        {
            ae.printStackTrace();
        }
        // Then
        Throwable exception = assertThrows(AccountDoesNotExistsException.class, () -> managerAccount.removeAccount(account));
        assertEquals("Account does not exist!", exception.getMessage());
    }

    @Test
    public void was_account_status_changed()
    {
        // Given
        ManagerAccount managerAccount = new ManagerAccount();
        // When
        try
        {
            managerAccount.addAccount(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        boolean result = managerAccount.changeAccountStatus(account, BANNED);
        // Then
        assertTrue(result);
    }

    /**
     * Account doesnt exists in the AccountList, false was expected
     */
/*
    @Test
    public void change_account_status_when_account_does_not_exists() //
    {
        // Given
        ManagerAccount managerAccount = new ManagerAccount();
        // Then
        boolean result = managerAccount.changeAccountStatus(account, BANNED);
        assertFalse(result);
    }

    @Test
    public void change_account_status_but_account_status_is_already_the_same()
    {
        // Given
        ManagerAccount managerAccount = new ManagerAccount();
        // When
        try
        {
            managerAccount.addAccount(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        boolean result = managerAccount.changeAccountStatus(account, ACTIV);
        // Then
        assertFalse(result);
    }
}*/
