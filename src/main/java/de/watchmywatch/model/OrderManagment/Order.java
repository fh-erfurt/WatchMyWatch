package de.watchmywatch.model.OrderManagment;

import java.util.Date;
import java.util.logging.Logger;

import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.Helper.DatabaseEntity;

import javax.persistence.*;

/**
 * Class which represents an Order
 * @author Michael Hopp
 */
// TODO: Wird in DB Tabellen noch nicht angelegt!
@Entity
public class Order extends DatabaseEntity
{
    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final double SHIPPINGFEE = 5.90;     // Constant Shipping cost.

    @Temporal( TemporalType.TIMESTAMP )
    private Date ordered;

    @Temporal( TemporalType.TIMESTAMP )
    private Date shipped;

    // TODO: Fehlt noch in DB Tabellen...
    @ManyToOne
    private Address shippingAddress;

    // TODO: Enum
    private OrderStatus orderStatus;

    // TODO: Enum
    private ShippingStatus shippingStatus;

    private double total;

    @OneToOne
    private Shoppingcart shoppingcart;

    @OneToOne
    private Payment payment;

    // Constructor without Parameters for JPA
    // TODO: Bleibt einfach leer?
    public Order(){}
    /*
        public Order() {
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = null;
        this.orderStatus = OrderStatus.PENDING;
        this.shippingStatus = ShippingStatus.PENDING;
        // TODO: Kann das ohne übergebene shoppingcart noch konsistent sein?
        this.shoppingcart = null;
        this.total = 0.0;
        this.payment = new Payment();
        logger.info("New Order was created.");
    }
    */
    // TODO: ADD Parent Constructor in Child
    /**
     * Creates an Order Object without PaymentMethod.
     * @param address       Address for shipping and billing.
     * @param shoppingcart  List of watches, which shall be ordered
     * @author Michael Hopp
     */
    public Order(Address address, Shoppingcart shoppingcart) throws ShoppingcartEmptyException {
        checkShoppingcartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.PENDING;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.total = shoppingcart.getTotal() + SHIPPINGFEE;
        this.payment = new Payment();
        logger.info("New Order was created.");
    }

    /**
     * Creates an Order Object with PaymentMethod.
     * @param address       Address for shipping and billing.
     * @param shoppingcart  List of watches, which shall be ordered
     * @param paymentMethod How the Order shall be paid.
     * @author Michael Hopp
     */
    public Order(Address address, Shoppingcart shoppingcart, PaymentMethod paymentMethod) throws ShoppingcartEmptyException {
        checkShoppingcartEmpty(shoppingcart);
        this.ordered = new Date();
        this.shipped = null;
        this.shippingAddress = address;
        this.orderStatus = OrderStatus.PENDING;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.total = shoppingcart.getTotal() + SHIPPINGFEE;
        this.payment = new Payment(paymentMethod);
        logger.info("New Order was created.");
    }

    /**
     * Checks if the Shoppingcart contains any Items: If not - throws ShoppingcartEmptyException
     * @param shoppingcart Shoppingcart which will be checked
     * @author Michael Hopp
     */
    private void checkShoppingcartEmpty(Shoppingcart shoppingcart) throws ShoppingcartEmptyException {
        if (shoppingcart.getItems().isEmpty())
        {
            logger.warning("Shoppingcart in Order cannot be empty");
            throw new ShoppingcartEmptyException("Shoppingcart in Order cannot be empty");
        }
    }

    public void setShoppingcart(Shoppingcart shoppingcart) {
    this.shoppingcart = shoppingcart;
}
    public Date getOrderDate()
    {
        return this.ordered;
    }

    public void setOrderDate(Date date)
    {
        this.ordered = date;
        logger.info("OrderDate was set to " + date + ".");
    }

    public Date getShipDate()
    {
        return this.shipped;
    }

    public void setShipDate(Date date)
    {
        this.shipped =date;
    }

    public Address getAddress()
    {
        return this.shippingAddress;
    }

    public void setAddress(Address newAddress)
    {
        this.shippingAddress = newAddress;
    }

    public OrderStatus getOrderStatus()
    {
        return this.orderStatus;
    }
    public void setOrderStatus(OrderStatus newOrderStatus)
    {
        this.orderStatus = newOrderStatus;
    }

    public ShippingStatus getShippingStatus()
    {
        return this.shippingStatus;
    }

    /**
     * Sets the ShippingStatus of an Order and if newShippingStatus is SENT, sets shipping date to current time
     * @param newShippingStatus Desired new ShippingStatus
     * @author Michael Hopp
     */
    public void setShippingStatus(ShippingStatus newShippingStatus)
    {
        this.shippingStatus = newShippingStatus;
        logger.info("ShippingStatus was set to " + newShippingStatus + ".");
        if(newShippingStatus == ShippingStatus.SENT)
        {
            setShipDate(new Date());
        }

    }

    public double getTotal()
    {
        calcTotal();
        return this.total;
    }

    /**
     * Calculates new total for Order including SHIPPINGFEE.
     * @author Michael Hopp
     */
    public void calcTotal()
    {
        this.total = this.shoppingcart.getTotal() + SHIPPINGFEE;
    }

    public Shoppingcart getShoppingcart(){
    return this.shoppingcart;
    }

    public Payment getPayment(){
    return this.payment;
    }

    public void setPayment(Payment payment)
    {
    this.payment = payment;
    }

    /**
     * Checks whether or not this Order has a set datePaid in its Payment.
     * @return true if datePaid in this Payment is set, else false
     * @author Michael Hopp
     */
    public boolean isPaid()
    {
        return this.payment.getDatePaid() != null;
    }

    // TODO: Apply Principle of Single Responsibilty to pay() ...
    /**
     * Pays given Order, sends it and thereby completes Order.
     * @return true if Order wasn't paid yet and could be paid, else false
     * @author Michael Hopp
     */
    public boolean pay(){
        boolean success = false;
        if(!isPaid()) {
            this.getPayment().setDatePaid(new Date());
            this.setShippingStatus(ShippingStatus.SENT);
            this.setOrderStatus(OrderStatus.COMPLETE);
            success = true;
            logger.info("Order was paid.");
        }
        else
        {
            logger.info("Order is already paid...");
        }
        return success;
    }
}
