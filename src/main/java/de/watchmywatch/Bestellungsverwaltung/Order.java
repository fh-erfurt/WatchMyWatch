package de.watchmywatch.Bestellungsverwaltung;

import java.util.Date;
import de.watchmywatch.Bestellungsverwaltung.OrderStatus;
import de.watchmywatch.Bestellungsverwaltung.ShippingStatus;


public class Order
{
public Order(String addressID, Shoppingcart shoppingcart)
    {
    this.ordered = new Date();
    this.shipped = null;
    this.addressID = addressID;
    this.orderStatus = OrderStatus.PENDING;
    this.shippingStatus = ShippingStatus.PENDING;
    // TODO: Total per shoppingcart berechnen -> (shoppingcart.calcTotal()).add(VERSANDKOSTEN o.Ä.);
    this.shoppingcart = shoppingcart;
    this.payment = new Payment();
    }

    private String id;
    private Date ordered;
    private Date shipped;
    private String addressID;
    private OrderStatus orderStatus;
    private ShippingStatus shippingStatus;
    private double total;
    private Shoppingcart shoppingcart;
    private Payment payment;

    Date getOrderDate(){
    return this.ordered;
    }
    // TODO: additional logic needed here?
    void setOrderDate(Date date){
    this.ordered = date;
    }

    Date getShipDate(){
    return this.shipped;
    }
    void setShipDate(Date date){
    this.shipped =date;
    }

    String getID(){
    return this.id;
    }
    // No SetID -> ID is set only in constructor

    String getAddressID(){
    return this.addressID;
    }
    void setAddressID(String newAddressID){
    this.addressID = newAddressID;
    }

    OrderStatus getOrderStatus(){
    return this.orderStatus;
    }
    void setOrderStatus(OrderStatus newOrderStatus){
    this.orderStatus = newOrderStatus;
    }

    ShippingStatus getShippingStatus(){
    return this.shippingStatus;
    }
    void setShippingStatus(ShippingStatus newShippingStatus){
    this.shippingStatus = newShippingStatus;
    }

// TODO: Versandkosten, Rabatte o.Ä. mit einbeziehen. Ansonsten redundant, weil total bereits in Shoppincart steht...
/*
    double getTotal(){
    return this.total;
    }
    public void setTotal(double total)
    {
    this.total = total;
    }
*/

Shoppingcart getShoppingcart(){
    // Referenz?
    return this.shoppingcart;
    }

    public void setShoppingcart(Shoppingcart shoppingcart)
    {
    this.shoppingcart = shoppingcart;
    }

    Payment getPayment(){
    return this.payment;
    }

    public void setPayment(Payment payment)
    {
    this.payment = payment;
    }
}
