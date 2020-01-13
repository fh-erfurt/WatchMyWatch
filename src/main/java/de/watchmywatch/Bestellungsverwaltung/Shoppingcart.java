package de.watchmywatch.Bestellungsverwaltung;


import java.math.BigDecimal;
import java.util.List;

public class Shoppingcart
{
    private double total;
    // TODO: OrderItem direkt durch Watch ersetzen.
    //private List<OrderItem> items;

public double getTotal()
    {
    return total;
    }

// Calculates the sum of (prices+fee)*quantity in items and sets it as total. Default 0.0
public void calcTotal()
    {
    double result = 0.0;
    /*if(!items.isEmpty())
    {
        for (OrderItem temp: items)
        {
        // TODO: Uhrenpreis aus Orderitem über Watch inklusive fee ermitteln
        // result.add((temp.getPrice()).multiply(temp.getQuantity()));
        }
    }*/
    this.total = result;
    }
}
