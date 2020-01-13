package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Bestellungsverwaltung.OrderItem;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account
{
    private Customer customer;
    private String securePassword;
    private String salt;
    private String billingAddress;
    private Date opened;
    private Enum defaultPaymentMethod;
    private Enum accountStatus;
    private Shoppingcart shoppingCart;
    private List<String> orders;

    public Account(Customer customer, String securePassword, String salt, String billingAddress, Date opened,
                   Enum defaultPaymentMethod, Enum accountStatus, Shoppingcart shoppingCart)
    {
        this.customer = customer;
        this.securePassword = securePassword;
        this.salt = salt;
        this.billingAddress = billingAddress;
        this.opened = opened;
        this.defaultPaymentMethod = defaultPaymentMethod;
        this.accountStatus = accountStatus;
        this.shoppingCart = shoppingCart;
        this.orders = new ArrayList<String>();
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public String getSecurePassword()
    {
        return securePassword;
    }

    public String getSalt()
    {
        return salt;
    }

    public String getBillingAddress()
    {
        return billingAddress;
    }

    public Date getOpened()
    {
        return opened;
    }

    public Enum getDefaultPaymentMethod()
    {
        return defaultPaymentMethod;
    }

    public Enum getAccountStatus()
    {
        return accountStatus;
    }

    public Shoppingcart getShoppingCart()
    {
        return shoppingCart;
    }

    public List<String> getOrders()
    {
        return orders;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public void setAccountStatus(Enum accountStatus)
    {
        this.accountStatus = accountStatus;
    }

    public void setBillingAddress(String billingAddress)
    {
        this.billingAddress = billingAddress;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public void setSecurePassword(String securePassword)
    {
        this.securePassword = securePassword;
    }

    public void setDefaultPaymentMethod(Enum defaultPaymentMethod)
    {
        this.defaultPaymentMethod = defaultPaymentMethod;
    }

    public void setOpened(Date opened)
    {
        this.opened = opened;
    }

    public void setOrders(List<String> orders)
    {
        this.orders = orders;
    }

    public void setShoppingCart(Shoppingcart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }
}