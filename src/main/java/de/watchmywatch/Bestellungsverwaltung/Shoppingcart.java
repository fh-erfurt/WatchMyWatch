package de.watchmywatch.Bestellungsverwaltung;


import de.watchmywatch.Uhrenverwaltung.Watch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Michael Hopp
 */
public class Shoppingcart
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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

    /**
     * Calculates the sum of prices in items and sets it as total.
     * Default = 0.0
     */
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
        if (watch != null && watch.validate())
        {
            items.add(watch);
            this.total+=watch.getPriceWithFee();
        }
    }


    /**
     * Removes given Watch from ShoppingCart-List items.
     * @return true if successful, false if watch not found.
     */
    public boolean removeWatch(Watch watch)
    {
        boolean result = false;
        if (watch != null)
        {
            items.remove(watch);
            this.total -= watch.getPriceWithFee();
            result = true;
        }
        return result;
    }

    /**
     * Removes all posts of given Watch from ShoppingCart-List items.
     * @return amount of removed Watches as int. Zero if none were found.
     */
    public int removeAllOccurancesOfWatch(Watch watch)
    {
        int result = 0;
        if (watch != null)
        {
            while(items.contains(watch))
            {
                items.remove(watch);
                this.total -= watch.getPriceWithFee();
                result +=1;
            }
        }
        return result;
    }


    /**
     * Removes all Watches from Shoppingcart-List and sets total as 0.0
     */
    public void clear()
    {
        items.clear();
        this.total = 0.0;
    }
}