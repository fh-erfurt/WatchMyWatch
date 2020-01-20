package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Account
{
    private Customer customer;
    private String securePassword;
    private byte[] salt;
    private String billingAddress;
    private Date opened;
    private Enum defaultPaymentMethod;
    private Enum accountStatus;
    private Shoppingcart shoppingCart;
    private List<String> orders;

    public Account(Customer customer, String passwordToHash, byte[] salt, String billingAddress, Date opened,
                   Enum defaultPaymentMethod, Enum accountStatus, Shoppingcart shoppingCart)
    {
        this.customer = customer;
        this.securePassword = get_SHA_1_SecurePassword(passwordToHash, salt);
        this.salt = salt;
        this.billingAddress = billingAddress;
        this.opened = opened;
        this.defaultPaymentMethod = defaultPaymentMethod;
        this.accountStatus = accountStatus;
        this.shoppingCart = shoppingCart;
        this.orders = new ArrayList<String>();
    }
    private static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    public Customer getCustomer()
    {
        return customer;
    }

    public String getSecurePassword()
    {
        return securePassword;
    }

    public byte[] getSalt()
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

    public void setSalt(byte[] salt)
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
