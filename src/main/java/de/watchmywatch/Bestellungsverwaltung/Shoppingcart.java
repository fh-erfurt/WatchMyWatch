package de.watchmywatch.Bestellungsverwaltung;


import de.watchmywatch.Uhrenverwaltung.Watch;

import java.math.BigDecimal;
import java.util.List;

public class Shoppingcart
{
    private double total;
    private List<Watch> items;
public double getTotal()
    {
    return total;
    }

// Calculates the sum of (prices+fee)*quantity in items and sets it as total. Default 0.0
public void calcTotal()
    {
    double result = 0.0;
    if(!items.isEmpty())
    {
        for (Watch temp: items)
        {
        result += temp.getPriceWithFee();
        }
    }
    this.total = result;
    }
public void addWatch(Watch watch)
    {
    // TODO: Include function which validates a Watch object
    if (watch != null)
        {
        items.add(watch);
        calcTotal();
        }

    }
public void removeWatch(Watch watch)
    {
    // TODO:
    }
}