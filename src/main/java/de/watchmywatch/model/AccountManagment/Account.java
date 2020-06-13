package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.DatabaseEntity;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.PaymentMethod;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.model.Helper.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class which represents an Account
 *
 * @author Anton Bespalov
 */
@Entity
public class Account extends DatabaseEntity
{
    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @OneToOne
    private Customer customer;

    private String securePassword;

    @ManyToOne
    private Address billingAddress;

    private Date opened;


    private PaymentMethod paymentMethod;


    private AccountStatus accountStatus;

    @OneToOne(cascade= CascadeType.PERSIST)
    private Shoppingcart shoppingCart;

    @OneToMany(cascade= CascadeType.PERSIST)
    private List<Order> orders = new ArrayList<>();

    public Account() {
    }

    /**
     * @param customer       the given customer
     * @param passwordToHash not hashed password
     * @param billingAddress Address for the bill
     * @param opened         Date when the account was opened
     * @param PaymentMethod  Enum of the paymentmethod
     * @param accountStatus  Enum of the accountstatus
     * @param shoppingCart   shoppingcart from the customer
     * @author Anton Bespalov
     */


    public Account(Customer customer, String passwordToHash, Address billingAddress, Date opened,
                   PaymentMethod PaymentMethod, AccountStatus accountStatus, Shoppingcart shoppingCart)
    {
        this.customer = customer;
        this.securePassword = get_SHA_256_SecurePassword(passwordToHash);
        this.billingAddress = billingAddress;
        this.opened = opened;
        this.paymentMethod = PaymentMethod;
        this.accountStatus = accountStatus;
        this.shoppingCart = shoppingCart;
        this.orders = new ArrayList<>();
    }

    /**
     * Hash-Function
     *
     * @param passwordToHash password that should be hashed
     * @return hashed password
     */
    public static String get_SHA_256_SecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes)
            {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * changePassword
     *
     * @param newPasswordToHash password that should be hashed
     *                          hashing the new password and replacing it
     */
    public void changePassword(String newPasswordToHash)
    {
        this.securePassword = get_SHA_256_SecurePassword(newPasswordToHash);
    }

    /**
     * Adding an order to the Orderlist
     *
     * @param order order that schould be added
     * @return true when the order was added
     */
    public boolean addOrder(Order order)
    {
        orders.add(order);
        logger.info("Order was added.");
        return true;
    }

    /**
     * Removing an Order
     *
     * @param order order that schould be removed
     * @return true, when the order was removed / false, when the order was not found
     */
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

    public List<Order> getOrders()
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

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

    public void setShoppingCart(Shoppingcart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }

    /**
     * For Payment logic by principle "First Come First Serve": Oldest unpaid Order should be paid first.
     * Returns the oldest unpaid Order of this Account.
     *
     * @return Oldest unpaid Order of this account
     * @author Michael Hopp
     */
    public Order getOldestUnpaidOrder()
    {
        return orders.stream()
                .filter(order -> !order.isPaid())  // Filter for unpaid Orders
                .min(Comparator.comparing(Order::getOrderDate)) // select oldest
                .get();
    }
}
