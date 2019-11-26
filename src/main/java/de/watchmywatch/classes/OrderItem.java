package de.watchmywatch.classes;

import java.math.BigDecimal;

public class OrderItem
{
    private int quantity;
    private BigDecimal price;
    private String watchID;

    public int getQuantity()
    {
        return quantity;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getWatchID()
    {
        return watchID;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public void setWatchId(String watchID)
    {
        this.watchID = watchID;
    }
}
