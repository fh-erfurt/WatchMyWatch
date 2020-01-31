package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Bestellungsverwaltung.Order;
import de.watchmywatch.Bestellungsverwaltung.PaymentMethod;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class Account
{
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private Customer customer;
    private String securePassword;
    private Address billingAddress;
    private Date opened;
    private PaymentMethod paymentMethod;
    private AccountStatus accountStatus;
    private Shoppingcart shoppingCart;
    private ArrayList<Order> orders;

    /**
     *
     * @param customer       the given customer
     * @param passwordToHash not hashed password
     * @param billingAddress Address for the bill
     * @param opened         Date when the account was opened
     * @param PaymentMethod  Enum of the paymentmethod
     * @param accountStatus  Enum of the accountstatus
     * @param shoppingCart   shoppingcart from the customer
     */
    public Account(Customer customer, String passwordToHash, /*byte[] salt,*/ Address billingAddress, Date opened,
                   PaymentMethod PaymentMethod, AccountStatus accountStatus, Shoppingcart shoppingCart)
    {
        this.customer = customer;
        this.securePassword = get_SHA_256_SecurePassword(passwordToHash);
        this.billingAddress = billingAddress;
        this.opened = opened;
        this.paymentMethod = PaymentMethod;
        this.accountStatus = accountStatus;
        this.shoppingCart = shoppingCart;
        this.orders = new ArrayList<Order>();
    }

    public static String get_SHA_256_SecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public void changePassword(String newPasswordToHash)
    {
        this.securePassword = get_SHA_256_SecurePassword(newPasswordToHash);
    }

    public boolean addOrder(Order order)
    {
        orders.add(order);
        logger.info("Order was added.");
        return true;
    }

    public boolean removeOrder(Order order)
    {
        if (orders.contains(order))
        {
            orders.remove(order);
            logger.info("Order was succesfull removed");
            return true;
        } else
        {
            logger.info("Order was not found or does not exist.");
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

    public Address getBillingAddress()
    {
        return billingAddress;
    }

    public Date getOpened()
    {
        return opened;
    }

    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }

    public AccountStatus getAccountStatus()
    {
        return accountStatus;
    }

    public Shoppingcart getShoppingCart()
    {
        return shoppingCart;
    }

    public ArrayList<Order> getOrders()
    {
        return orders;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public void setAccountStatus(AccountStatus accountStatus)
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

    public void setPaymentMethod(PaymentMethod PaymentMethod)
    {
        this.paymentMethod = PaymentMethod;
    }

    public void setOpened(Date opened)
    {
        this.opened = opened;
    }

    public void setOrders(ArrayList<Order> orders)
    {
        this.orders = orders;
    }

    public void setShoppingCart(Shoppingcart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }

    /**
     * First Come First Serve: Oldest unpaid Order should be paid first.
     *
     * @return Oldest unpaid Order of this account
     * @author Michael Hopp, noch verändert von Anton Bespalov
     */
    public Order getOldestUnpaidOrder()
    {
        return orders.stream()
                .filter(order -> !order.isPaid())  // Filter for unpaid Orders
                .min(Comparator.comparing(Order::getOrderDate)) // select oldest
                .get();
    }
}
