package de.watchmywatch;

import de.watchmywatch.Accounterwaltung.Account;
import de.watchmywatch.Accounterwaltung.AccountStatus;
import de.watchmywatch.Accounterwaltung.Customer;
import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Bestellungsverwaltung.Order;
import de.watchmywatch.Bestellungsverwaltung.OrderStatus;
import de.watchmywatch.Bestellungsverwaltung.PaymentMethod;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Exceptions.NameException;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.Uhrenverwaltung.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShop
{
    // create some reusable objects
    Address myAddress = new Address("Grolmannstraße 13","Erfurt", "Germany", "99085");
    Shoppingcart myShoppingcart = new Shoppingcart();
    Manufacturer manufacturer = new Manufacturer("Apple", new Person("anton.bespalov@fh-erfurt.de", myAddress,
            "01716181447", "Anton", "Bespalov"), myAddress);
    Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM,25, 1, ConnectionType.BAND);
    Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM,25, 2, 2, ConnectionType.BAND);
    Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM,50, 2);
    Watch watch = new Watch("Swatch","Test", bracelet, casing, clockwork);

    public TestShop() throws NameException
    {
    }

    @Test
    public void happy_path() throws NameException
    {
    //Given
        // The desired watch
        Watch watch1 = new Watch("Rolex 42", "Attributes: +2 Handshaking, +3 Intimidation",
                bracelet, casing, clockwork);
    //When
        // User creates new Account
        Account myAccount = new Account(
                new Customer("michael.hopp@fh-erfurt.de", myAddress,"0123456789", "Michael" , "Hopp",
                new Date(1996,9,24)),
                "root", myAddress, new Date(), PaymentMethod.PAYPAL, AccountStatus.ACTIV, myShoppingcart);
        // User puts new Watch into his*her shoppingcart
        myAccount.getShoppingCart().addWatch(watch1);
        // User checks out
        Order myOrder = new Order(myAccount.getCustomer().getAddress(), myAccount.getShoppingCart());
        myOrder.getPayment().setPaymentMethod(PaymentMethod.PAYPAL);
        myAccount.addOrder(myOrder);
        // User Paid
        // TODO: Auf entsprechende Order zugreifen und status aktualisieren.
    //Then

    }
}
