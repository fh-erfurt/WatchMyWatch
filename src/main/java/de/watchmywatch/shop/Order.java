package de.watchmywatch.shop;

import java.util.Date;

public class Order
{
    private String id;
    private Date ordereed;
    private Date shipped;
    private String addressId;
    private Enum OrderStaus;
    private Enum ShippingStatus;
    private Decimal total;
    private Shoppingcart shoppingcart;
    private Payment payment;
}
