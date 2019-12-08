package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManagerWatchpart
{
    private final static Logger log = Logger.getLogger(ManagerWatchpart.class.getName());
    private static Map<Integer, Watchpart> watchpartMap = new HashMap<Integer, Watchpart>();
    private static int idCounter = 1;

    public boolean addWatchpart(Watchpart watchpart)
    {
        try
        {
            watchpartMap.put(idCounter, watchpart);
            ++idCounter;
            log.info("Added Watchpart");
        }
        catch (Exception e)
        {
            log.log(Level.SEVERE, "Failed to add watchpart", e);
            return false;
        }
        return true;
    }

    //returns null if no Watchpart is found
    public Watchpart getWatchpartByID(int id)
    {
        try
        {
            return watchpartMap.get(id);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public boolean removeWatchpartByID(Integer id)
    {
        try
        {
            watchpartMap.remove(id);
            log.info("Removed watchpart");
        }
        catch (Exception e)
        {
            log.log(Level.SEVERE, "Failed to remove watchpart", e);
            return false;
        }
        return true;
    }

    public boolean removeWatchpartByObject(Watchpart part)
    {
        try
        {
            log.info("Removed watchpart");
        }
        catch (Exception e)
        {
            log.log(Level.SEVERE, "Failed to add watchpart", e);
            return false;
        }
        return true;
    }

    public boolean setNewPrice(Integer id, BigDecimal newPrice)
    {
        try
        {
            watchpartMap.get(id).setPrice(newPrice);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean changeManufacturerID(Integer id, int manufacturerID)
    {
        try
        {
            watchpartMap.get(id).setManufacturerID(manufacturerID);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean changeManufacturerPartID(Integer id, String manufacturerPartID)
    {
        try
        {
            watchpartMap.get(id).setManufacturerPartId(manufacturerPartID);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean changeAmountAvailable(Integer id, int amountAvailable)
    {
        try
        {
            watchpartMap.get(id).setAmountAvailable(amountAvailable);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public int amountOfWatchpartsInMap()
    {
        return watchpartMap.size();
    }

    protected void resetClass()
    {
        log.info("Cleared the class");
        watchpartMap.clear();
        idCounter = 1;
    }
}
