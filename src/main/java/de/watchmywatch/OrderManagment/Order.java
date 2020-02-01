package de.watchmywatch.OrderManagment;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import de.watchmywatch.Helper.Address;

/**
 * @author Michael Hopp
 */
public class Order
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

    public Order(Address address, Shoppingcart shoppingcart)
    {
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

    public Order(Address address, Shoppingcart shoppingcart, PaymentMethod paymentMethod)
    {
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
     * If newShippingStatus is SENT, sets shipping date to current time
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

    public void setShoppingcart(Shoppingcart shoppingcart)
    {
    this.shoppingcart = shoppingcart;
    this.calcTotal();
    }

    public Payment getPayment(){
    return this.payment;
    }

    public void setPayment(Payment payment)
    {
    this.payment = payment;
    }

    public boolean isPaid()
    {
        return this.payment.getDatePaid() != null;
    }

    // Pays given Order, sends it and thereby completes Order.
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
