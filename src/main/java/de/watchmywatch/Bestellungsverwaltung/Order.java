package de.watchmywatch.Bestellungsverwaltung;

import java.time.LocalDateTime;
import de.watchmywatch.Bestellungsverwaltung.OrderStatus;
import de.watchmywatch.Bestellungsverwaltung.ShippingStatus;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;


public class Order
{

    private static final double SHIPPINGFEE = 5.90;     // Konstante für Versandkosten, die immer anzurechnen sind
    private LocalDateTime ordered;
    private LocalDateTime shipped;
    private Address address;
    private OrderStatus orderStatus;
    private ShippingStatus shippingStatus;
    private double total;
    private Shoppingcart shoppingcart;
    private Payment payment;

    public Order(Address address, Shoppingcart shoppingcart)
    {
        this.ordered = LocalDateTime.now();
        this.shipped = null;
        this.address = address;
        this.orderStatus = OrderStatus.PENDING;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.total = shoppingcart.getTotal() + SHIPPINGFEE;
        this.payment = new Payment();
    }

    LocalDateTime getOrderDate()
    {
        return this.ordered;
    }

    void setOrderDate(LocalDateTime date)
    {
        this.ordered = date;
    }

    LocalDateTime getShipDate()
    {
        return this.shipped;
    }

    void setShipDate(LocalDateTime date)
    {
        this.shipped =date;
    }

    Address getAddress()
    {
        return this.address;
    }

    void setAddress(Address newAddress)
    {
        this.address = newAddress;
    }

    OrderStatus getOrderStatus()
    {
        return this.orderStatus;
    }
    void setOrderStatus(OrderStatus newOrderStatus)
    {
        this.orderStatus = newOrderStatus;
    }

    ShippingStatus getShippingStatus()
    {
        return this.shippingStatus;
    }

    // If newShippingStatus is SENT, sets shipping date to current time
    void setShippingStatus(ShippingStatus newShippingStatus)
    {
        this.shippingStatus = newShippingStatus;
        if(newShippingStatus == ShippingStatus.SENT)
        {
            this.shipped = LocalDateTime.now();
        }
    }

    double getTotal()
    {
        calcTotal();
        return this.total;
    }

    public void calcTotal()
    {
        this.total = this.shoppingcart.getTotal() + SHIPPINGFEE;
    }

    Shoppingcart getShoppingcart(){
    // TODO: Als Referenz übergeben?
    return this.shoppingcart;
    }

    public void setShoppingcart(Shoppingcart shoppingcart)
    {
    this.shoppingcart = shoppingcart;
    this.calcTotal();    // Neue Gesamtkosten berechnen
    }

    Payment getPayment(){
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
}
