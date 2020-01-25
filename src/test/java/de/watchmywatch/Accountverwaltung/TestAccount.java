package de.watchmywatch.Accountverwaltung;

import de.watchmywatch.Accounterwaltung.Account;
import de.watchmywatch.Accounterwaltung.Customer;
import de.watchmywatch.Bestellungsverwaltung.Order;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import static de.watchmywatch.Accounterwaltung.Account.get_SHA_256_SecurePassword;



public class TestAccount
{
    @Test
    public void get_secure_password()
    {
       String securePassword =  get_SHA_256_SecurePassword("Salamination", new byte[256]);

        assertEquals("f1aca9ab91d28dd37c4f7b3595afe26a4eec88c138b0fac8bbeb6062d88df126", securePassword);
    }
}
