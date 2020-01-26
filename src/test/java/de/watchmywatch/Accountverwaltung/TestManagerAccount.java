package de.watchmywatch.Accountverwaltung;

import de.watchmywatch.Accounterwaltung.Account;
import de.watchmywatch.Accounterwaltung.Customer;
import de.watchmywatch.Bestellungsverwaltung.Order;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.Accounterwaltung.ManagerAccount;
import org.junit.Test;

import java.util.Date;

import static de.watchmywatch.Accounterwaltung.AccountStatus.ACTIV;
import static de.watchmywatch.Bestellungsverwaltung.PaymentMethod.PAYPAL;
import static org.junit.Assert.assertEquals;

public class TestManagerAccount
{
    Address address = new Address("Lilo-Herrmann-Straße", "Erfurt", "Thüringen", "99086");
    Account account =  new Account(new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov",
            new Date(1998, 9, 23)), "Salami", address, new Date(2020, 1, 26), PAYPAL, ACTIV,
            new Shoppingcart());
    Shoppingcart shoppingcart = new Shoppingcart();
    Order order = new Order(address, shoppingcart);

    @Test
    public void adding_a_account_to_accounts_when_account_does_not_exists()
    {
    }
}
