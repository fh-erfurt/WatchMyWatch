package de.watchmywatch.Accountverwaltung;

import de.watchmywatch.Accounterwaltung.Account;
import de.watchmywatch.Accounterwaltung.Customer;
import de.watchmywatch.Bestellungsverwaltung.Order;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Exceptions.AccountAlreadyExistsException;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.Accounterwaltung.ManagerAccount;
import org.junit.Test;

import java.util.Date;

import static de.watchmywatch.Accounterwaltung.AccountStatus.*;
import static de.watchmywatch.Bestellungsverwaltung.PaymentMethod.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestManagerAccount
{
    Address address = new Address("Lilo-Herrmann-Straße", "Erfurt", "Thüringen", "99086");
    Account account =  new Account(new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov",
            new Date(1998, 9, 23)), "Salami", address, new Date(2020, 1, 26), PAYPAL, ACTIV,
            new Shoppingcart());
    Shoppingcart shoppingcart = new Shoppingcart();
    Order order = new Order(address, shoppingcart);

    @Test
    public void adding_a_account_to_accountList_when_account_does_not_exists() throws AccountAlreadyExistsException
    {
       ManagerAccount.addAccount(account);
       assertThrows(AccountAlreadyExistsException.class, () -> {ManagerAccount.addAccount(account);});
    }

    @Test
    public void adding_two_time_the_same_account() throws AccountAlreadyExistsException
    {
        ManagerAccount.addAccount(account);
        ManagerAccount.addAccount(account);
    }
}
