package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Bestellungsverwaltung.Order;
import de.watchmywatch.Bestellungsverwaltung.PaymentMethod;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Account
{
    private Customer customer;
    private String securePassword;
   // private byte[] salt;
    private Address billingAddress;
    private Date opened;
    private PaymentMethod paymentMethod;
    private Enum accountStatus;
    private Shoppingcart shoppingCart;
    private List<Order> orders;

    public Account(Customer customer, String passwordToHash, /*byte[] salt,*/ Address billingAddress, Date opened,
                   PaymentMethod PaymentMethod, Enum accountStatus, Shoppingcart shoppingCart)
    {
        this.customer = customer;
        this.securePassword = get_SHA_256_SecurePassword(passwordToHash/*, salt*/);
       // this.salt = salt;
        this.billingAddress = billingAddress;
        this.opened = opened;
        this.paymentMethod = PaymentMethod;
        this.accountStatus = accountStatus;
        this.shoppingCart = shoppingCart;
        this.orders = new ArrayList<Order>();
    }
    public static String get_SHA_256_SecurePassword(String passwordToHash/*, byte[] salt*/)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // md.update(salt);
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

    public void changePassword(String newPasswordToHash)
    {
        this.securePassword = get_SHA_256_SecurePassword(newPasswordToHash/*, this.salt*/);
    }

    public boolean addOrder(Order order)
    {
        orders.add(order);
        return true;
    }

    public boolean removeOrder(Order order)
    {
        if(orders.contains(order))
        {
            orders.remove(order);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public String getSecurePassword()
    {
        return securePassword;
    }

  /*  public byte[] getSalt()
    {
        return salt;
    }*/

    public Address getBillingAddress()
    {
        return billingAddress;
    }

    public Date getOpened()
    {
        return opened;
    }

    public Enum getPaymentMethod()
    {
        return paymentMethod;
    }

    public Enum getAccountStatus()
    {
        return accountStatus;
    }

    public Shoppingcart getShoppingCart()
    {
        return shoppingCart;
    }

    public List<Order> getOrders()
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

    public void setBillingAddress(Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }

   /* public void setSalt(byte[] salt)
    {
        this.salt = salt;
    }*/

    public void setSecurePassword(String securePassword)
    {
        this.securePassword = securePassword;
    }

    public void setPaymentMethod(Enum PaymentMethod)
    {
        this.paymentMethod = PaymentMethod;
    }

    public void setOpened(Date opened)
    {
        this.opened = opened;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

    public void setShoppingCart(Shoppingcart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }
}
