package de.watchmywatch.Bestellungsverwaltung;

import de.watchmywatch.Uhrenverwaltung.Watch;

import java.math.BigDecimal;

public class OrderItem
{
public OrderItem(Watch watch, int quantity)
    {

    }

    private int quantity;
    private Watch watch;


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
