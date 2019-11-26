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
}
