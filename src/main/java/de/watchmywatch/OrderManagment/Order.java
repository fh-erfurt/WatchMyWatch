package de.watchmywatch.OrderManagment;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import de.watchmywatch.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.Helper.Address;
import de.watchmywatch.Helper.DatabaseEntity;

/**
 * Class which represents an Order
 * @author Michael Hopp
 */
public class Order extends DatabaseEntity
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final double SHIPPINGFEE = 5.90;     // Constant Shipping cost.
    private LocalDateTime ordered;
    private LocalDateTime shipped;
    private Address shippingAddress;
    private OrderStatus orderStatus;
    private ShippingStatus shippingStatus;
    private double total;
    private Shoppingcart shoppingcart;
    private Payment payment;

    // TODO: ADD Parent Constructor in Child
    /**
     * Creates an Order Object without PaymentMethod.
     * @param address       Address for shipping and billing.
     * @param shoppingcart  List of watches, which shall be ordered
     * @author Michael Hopp
     */
    public Order(Address address, Shoppingcart shoppingcart) throws ShoppingcartEmptyException {
        checkShoppingcartEmpty(shoppingcart);
        this.ordered = LocalDateTime.now();
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
        this.ordered = LocalDateTime.now();
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
    public LocalDateTime getOrderDate()
    {
        return this.ordered;
    }

    public void setOrderDate(LocalDateTime date)
    {
        this.ordered = date;
        logger.info("OrderDate was set to " + date + ".");
    }

    public LocalDateTime getShipDate()
    {
        return this.shipped;
    }

    public void setShipDate(LocalDateTime date)
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
            setShipDate(LocalDateTime.now());
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
            this.getPayment().setDatePaid(LocalDateTime.now());
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
