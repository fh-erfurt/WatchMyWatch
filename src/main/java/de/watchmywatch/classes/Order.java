package de.watchmywatch.classes;

import java.math.BigDecimal;
import java.util.Date;
import de.watchmywatch.classes.OrderStatus;
import de.watchmywatch.classes.ShippingStatus;

public class Order
{
    private String id;
    private Date ordered;
    private Date shipped;
    private String addressID;
    private OrderStatus orderStatus;
    private ShippingStatus shippingStatus;
    private BigDecimal total;
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
    void setShippingStatus(Enum newShippingStatus){
    this.shippingStatus = newShippingStatus;
    }

    BigDecimal getTotal(){
    return this.total;
    }
    // TODO: Create Method for calculating the sum of Prices of Orderitems to Total price of Order

    Shoppingcart getShoppingcart(){
    // Referenz?
    return this.shoppingcart;
    }
    // TODO: Method for setting a reasonable Shoppingcart to Order

    Payment getPayment(){
    return this.payment;
    }
    // TODO: Method for setting Payment
}
