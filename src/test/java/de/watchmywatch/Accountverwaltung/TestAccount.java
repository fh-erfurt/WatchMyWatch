package de.watchmywatch.Accountverwaltung;

import de.watchmywatch.Accounterwaltung.Account;
import de.watchmywatch.Accounterwaltung.Customer;
import de.watchmywatch.Bestellungsverwaltung.Order;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;
import org.junit.Test;

import static de.watchmywatch.Accounterwaltung.AccountStatus.ACTIV;
import static de.watchmywatch.Bestellungsverwaltung.PaymentMethod.PAYPAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Date;

import static de.watchmywatch.Accounterwaltung.Account.get_SHA_256_SecurePassword;




public class TestAccount
{
    Address address = new Address("Lilo-Herrmann-Straße", "Erfurt", "Thüringen", "99086");
    Account account =  new Account(new Customer("anton.bespalov@fh-erfurt.de", address, "01716181447", "Anton", "Bespalov",
            new Date (1998, 9, 23)), "Salami", address, new Date(2020, 1, 26), PAYPAL, ACTIV,
            new Shoppingcart());
    Shoppingcart shoppingcart = new Shoppingcart();
    Order order = new Order(address, shoppingcart);
    @Test
    public void get_secure_password()
    {
        //Given
       String securePassword =  get_SHA_256_SecurePassword("Salamination"/*, new byte[256]*/);
        //When

        //Then
        assertEquals("f1aca9ab91d28dd37c4f7b3595afe26a4eec88c138b0fac8bbeb6062d88df126", securePassword);
    }

    @Test
    public void change_password()
    {
        //Given
        String newPassword = "VBGHJKOPOIU";
        //When
        account.changePassword(newPassword);
        //Then
        assertEquals("667558aa1d5b1f761a62cfabac2b6277d9be028dfe4ff296e966d4b39cd387cf", account.getSecurePassword());
    }
    @Test
    public void add_order_to_order_list()
    {
        //Given
        boolean result = account.addOrder(order);
        //When

        //Then
        assertTrue(result);
    }

    @Test
    public void remove_order_from_order_list()
    {
        //Given
        account.addOrder(order);
        boolean result = account.removeOrder(order);

        //Then

        //When
        assertTrue(result);
    }
}
