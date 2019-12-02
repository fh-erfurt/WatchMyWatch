package de.watchmywatch.classes;

import java.math.BigDecimal;
import java.util.Date;

public class Order
{
    private String id;
    private Date ordered;
    private Date shipped;
    private String addressID;
    private Enum OrderStatus;
    private Enum ShippingStatus;
    private BigDecimal total;
    private Shoppingcart shoppingcart;
    private Payment payment;

    Date getOrderDate(){
    return this->ordered;
    }
    // TODO
    void setOrderDate(Date date){
    // additional logic needed here?
    this->ordered = date;
    }

    Date getShipDate(){
    return this->shipped;
    }
    void setShipDate(Date date){
    this->shipped =date;
    }

    String getID(){
    return this->id;
    }
    // No SetID -> ID is set only in constructor

    String getAddressID(){
    return this->addressID;
    }
    bool setAddressID(int newAddressID){
    this->addressID = newAddressID;
    }

    // Todo: Create Enum Class OrderStatus
    Enum getOrderStatus(){
    return this->OrderStatus;
    }
    void setOrderStatus(Enum newOrderStatus){
    this->OrderStatus = newOrderStatus;
    }

    Enum getShippingStatus(){
    return this->ShippingStatus;
    }
    void setShippingStatus(Enum newShippingStatus){
    this->ShippingStatus =newShippingStatus;
    }

    BigDecimal getTotal(){
    return this->total;
    }
    // TODO: Create Method for calculating the sum of Prices of Orderitems to Total price of Order

    Shoppingcart getShoppingcart(){
    // Referenz?
    return this->shoppingcart;
    }
    // TODO: Method for setting a reasonable Shoppingcart to Order

    Payment getPayment(){
    return this->payment;
    }
    // TODO: Method for setting Payment
}
