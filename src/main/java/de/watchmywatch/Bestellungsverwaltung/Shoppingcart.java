package de.watchmywatch.Bestellungsverwaltung;


import de.watchmywatch.Uhrenverwaltung.Watch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shoppingcart
{
    private double total;

    private ArrayList<Watch> items = new ArrayList<>();


    public Shoppingcart()
    {
        calcTotal();
    }

    public double getTotal()
    {
        return total;
    }

    public ArrayList<Watch> getItems()
    {
        return items;
    }

    // Calculates the sum of prices in items and sets it as total. Default 0.0
    public void calcTotal()
    {
        double result = 0.0;
        if (!this.items.isEmpty())
        {
            for (Watch temp : this.items)
            {
                result += temp.getPriceWithFee();
            }
        }
        this.total = result;
    }

    public void addWatch(Watch watch)
    {
        if (watch != null)
        {
            items.add(watch);
            calcTotal();
        }
    }

    // Removes given Watch from ShoppingCart-List items and returns true if successful, false if watch not found
    // TODO: Was passiert, wenn mehrmals die gleiche Uhr enthalten ist?
    public boolean removeWatch(Watch watch)
    {
        boolean result = false;
        if (watch != null)
        {
            items.remove(watch);
            result = true;
        }
        return result;
    }
}