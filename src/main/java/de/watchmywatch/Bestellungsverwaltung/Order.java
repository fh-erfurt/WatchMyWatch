package de.watchmywatch.Bestellungsverwaltung;

import java.util.Date;
import de.watchmywatch.Bestellungsverwaltung.OrderStatus;
import de.watchmywatch.Bestellungsverwaltung.ShippingStatus;
import de.watchmywatch.Bestellungsverwaltung.Shoppingcart;
import de.watchmywatch.Helper.Address;


public class Order
{

    private static final double SHIPPINGFEE = 5.90;     // Konstante für Versandkosten, die immer anzurechnen sind
    private Date ordered;
    private Date shipped;
    private Address address;
    private OrderStatus orderStatus;
    private ShippingStatus shippingStatus;
    private double total;
    private Shoppingcart shoppingcart;
    private Payment payment;

    public Order(Address address, Shoppingcart shoppingcart)
    {
        this.ordered = new Date();
        this.shipped = null;
        this.address = address;
        this.orderStatus = OrderStatus.PENDING;
        this.shippingStatus = ShippingStatus.PENDING;
        this.shoppingcart = shoppingcart;
        this.total = shoppingcart.getTotal() + SHIPPINGFEE;
        this.payment = new Payment();
    }

    Date getOrderDate()
    {
        return this.ordered;
    }

    // TODO: additional logic needed here?
    void setOrderDate(Date date)
    {
        this.ordered = date;
    }

    Date getShipDate()
    {
        return this.shipped;
    }

    void setShipDate(Date date)
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
    void setShippingStatus(ShippingStatus newShippingStatus)
    {
        this.shippingStatus = newShippingStatus;
    }

    double getTotal()
    {
        return this.total;
    }

    public void setTotal()
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
    // Neue Gesamtkosten berechnen
    this.setTotal();
    }

    Payment getPayment(){
    return this.payment;
    }

    public void setPayment(Payment payment)
    {
    this.payment = payment;
    }
}
