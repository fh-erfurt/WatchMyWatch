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
    void setOrderDate(Date date){
    // zusätzlich Logik?
    this ordered = date;
    }
    Date getShipDate(){
    return this->shipped;
    }
    String getID(){
    return this->id;
    }
    String getAddressID(){
    return this->addressID;
    }
    Enum getOrderStatus(){
    return this->OrderStatus;
    }
    Enum getShippingStatus(){
    return this->ShippingStatus;
    }
    BigDecimal getTotal(){
    return this->total;
    }
    Shoppingcart getShoppingcart(){
    // Referenz?
    return this->shoppingcart;
    }
    Payment getPayment(){
    return this->payment;
    }

}
