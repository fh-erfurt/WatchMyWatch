package de.watchmywatch.Bestellungsverwaltung;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import de.watchmywatch.Bestellungsverwaltung.OrderStatus;
import de.watchmywatch.Bestellungsverwaltung.ShippingStatus;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;

/**
 * @author Michael Hopp
 */
public class Order
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final double SHIPPINGFEE = 5.90;     // Konstante für Versandkosten, die immer anzurechnen sind
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
    }

    public LocalDateTime getOrderDate()
    {
        return this.ordered;
    }

    public void setOrderDate(LocalDateTime date)
    {
        this.ordered = date;
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
     */
    public void setShippingStatus(ShippingStatus newShippingStatus)
    {
        this.shippingStatus = newShippingStatus;
        if(newShippingStatus == ShippingStatus.SENT)
        {
            this.shipped = LocalDateTime.now();
        }
    }

    public double getTotal()
    {
        calcTotal();
        return this.total;
    }

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
    this.calcTotal();    // Neue Gesamtkosten berechnen
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
        }
        return success;
    }
}
