package de.watchmywatch.OrderManagment;

import io.jonashackt.lectures.exercises.model.WatchManagment.Watch;
import java.util.ArrayList;
import java.util.logging.Logger;

// TODO: ADD Parent Constructor in Child
/**
 * Class which represents a Shoppingcart
 * @author Michael Hopp
 */
@Entity
public class Shoppingcart
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private double total;

    // TODO: ArrayList durch zb. List ersetzen -> JPA meckert sonst
    @OneToMany
    private ArrayList<Watch> items = new ArrayList<>();

    /**
     * Creates an empty Shoppingcart object with total = 0.0
     * @author Michael Hopp
     */
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
     * @author Michael Hopp
     */
    public void calcTotal()
    {
        double result = 0.0;
        if (!this.items.isEmpty())
        {
            for (io.jonashackt.lectures.exercises.model.WatchManagment.Watch temp : this.items)
            {
                result += temp.getPriceWithFee();
            }
        }
        this.total = result;
    }

    /**
     * Adds given Watch to ShoppingCart-List items.
     * @param watch Watch which shall be added to this Shoppingcart
     * @return True if successful, false if watch not found or invalid.
     * @author Michael Hopp
     */
    public boolean addWatch(Watch watch)
    {
        boolean result = false;
        if (watch != null && watch.validate())
        {
            items.add(watch);
            this.total+=watch.getPriceWithFee();
            result = true;
            logger.info("Added Watch to Shoppingcart.");
        }
        else
        {
            logger.warning("Watch not found or invalid.");
        }
        return result;
    }

    /**
     * Removes given Watch from ShoppingCart-List items.
     * @param watch Watch which shall be removed
     * @return true if successful, false if watch not found.
     * @author Michael Hopp
     */
    public boolean removeWatch(Watch watch)
    {
        boolean result = false;
        if (watch != null)
        {
            items.remove(watch);
            this.total -= watch.getPriceWithFee();
            result = true;
            logger.info("Removed Watch from Shoppingcart.");
        }
        else
        {
            logger.warning("Watch not found.");
        }
        return result;
    }

    /**
     * Removes all posts/occurrences of given Watch from ShoppingCart-List items.
     * @param watch Watch which shall be removed
     * @return amount of removed Watches as int. Zero if none were found.
     * @author Michael Hopp
     */
    public int removeAllOccurrencesOfWatch(Watch watch)
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
            logger.info(result + " Occurance(s) of Watch was/were removed from Shoppingcart.");
        }
        else
        {
            logger.warning("Watch not found.");
        }
        return result;
    }

    /**
     * Removes all Watches from Shoppingcart-List and sets total as 0.0
     * @author Michael Hopp
     */
    public void clear()
    {
        items.clear();
        this.total = 0.0;
        logger.info("Cleared Shoppingcart.");
    }
}