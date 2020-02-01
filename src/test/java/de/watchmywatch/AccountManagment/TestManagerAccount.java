package de.watchmywatch.AccountManagment;

import de.watchmywatch.OrderManagment.Shoppingcart;
import de.watchmywatch.Exceptions.AccountAlreadyExistsException;
import de.watchmywatch.Exceptions.AccountDoesNotExistsException;
import de.watchmywatch.Helper.Address;
import org.junit.Test;


import java.util.Calendar;
import java.util.Date;

import static de.watchmywatch.AccountManagment.AccountStatus.*;
import static de.watchmywatch.OrderManagment.PaymentMethod.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestManagerAccount
{
    private Address address = new Address("Lilo-Herrmann-Straße", "Erfurt", "Thüringen", "99086");
    private Account account = new Account(new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov",
            new Date(1998, Calendar.SEPTEMBER, 23)), "Salami", address, new Date(2020, Calendar.JANUARY, 26), PAYPAL, ACTIV,
            new Shoppingcart());
    private ManagerAccount managerAccount = new ManagerAccount();


    @Test
    public void adding_a_account_to_accountList_when_account_does_not_exists()
    {
        try
        {
            managerAccount.addAccount(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void adding_two_time_the_same_account()
    {
        try
        {
            managerAccount.addAccount(account);
            assertTrue(managerAccount.getAccountList().contains(account));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Throwable exception = assertThrows(AccountAlreadyExistsException.class, () -> managerAccount.addAccount(account));
        assertEquals("Account already Exists!", exception.getMessage());
    }

    @Test
    public void remove_a_account_from_account_list()
    {
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
    }

    @Test
    public void removing_a_account_which_not_exists()
    {
        try
        {
            managerAccount.removeAccount(account);
        }
        catch (AccountDoesNotExistsException ae)
        {
            ae.printStackTrace();
        }
        Throwable exception = assertThrows(AccountDoesNotExistsException.class, () -> managerAccount.removeAccount(account));
        assertEquals("Account does not exist!", exception.getMessage());
    }

    @Test
    public void was_account_status_changed()
    {
        try
        {
            managerAccount.addAccount(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        boolean result = managerAccount.changeAccountStatus(account, BANNED);
        assertTrue(result);
    }

    /**
     * Account doesnt exists in the AccountList, false was expected
     */
    @Test
    public void change_account_status_when_account_does_not_exists() //
    {
        boolean result = managerAccount.changeAccountStatus(account, BANNED);
        assertFalse(result);
    }

    @Test
    public void change_account_status_but_account_status_is_already_the_same()
    {
        try
        {
            managerAccount.addAccount(account);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        boolean result = managerAccount.changeAccountStatus(account, ACTIV);
        assertFalse(result);
    }
}
