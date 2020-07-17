package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.Helper.DatabaseEntity;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.PaymentMethod;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Entity
public class User extends DatabaseEntity {
    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @NotNull
    @Size(min=3, max = 7, message = "Firstname must be 2-35 characters long.")
    private String firstname;

    @NotNull
    @Size(min = 2, max = 35, message = "Lastname must be 2-35 characters long.")
    private String lastname;

    @Column(unique = true)
    @NotNull
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @NotNull
    @Size(min = 3 , message = "Password must be 3-9 characters long.")
    private String securePassword;

    @NotNull
    @NotBlank( message = "Require")
    private String phone;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
  
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @ManyToOne(cascade= CascadeType.PERSIST)
    private Address billingAddress;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne(cascade= CascadeType.PERSIST)
    private Shoppingcart shoppingCart;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    /**
     * @param firstname      firstname from the person
     * @param lastname       lastname from the person
     * @param email          the email from the person
     * @param securePassword the password for the account
     * @param phone          phonenumber from the person
     * @param address        the address of the person
     * @param dob            the date of birth from the customer
     * @param billingAddress Address for the bill
     * @param shoppingCart   shoppingcart from the customer
     * @author Anton Bespalov
     */
    public User(String firstname, String lastname, String email, String securePassword, String phone, Address address,  LocalDate dob,
                Address billingAddress, Shoppingcart shoppingCart) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.securePassword = securePassword;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.billingAddress = billingAddress;
        this.shoppingCart = shoppingCart;
        this.paymentMethod = null;
        this.accountStatus = AccountStatus.USER;
        this.orders = new ArrayList<>();
    }

    public User() {
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
     * setSecurePassword for Spring default setter
     *
     * @param newPasswordToHash password that should be hashed
     *                          hashing the new password and replacing it
     */
    public void setSecurePassword(String newPasswordToHash)
    {
        this.securePassword=newPasswordToHash;
    }

    /**
     * changePassword for our method tests
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

    public String getRolesForAuthority() {
        return "ROLE_" + accountStatus;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurePassword() {
        return securePassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Shoppingcart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Shoppingcart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}