package de.watchmywatch.Uhrenverwaltung;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManagerWatchpart
{
    private final static Logger log = Logger.getLogger(ManagerWatchpart.class.getName());
    private static ArrayList<Watchpart> watchpartList;

    public boolean addWatchpart(Watchpart watchpart)
    {
        try
        {
            watchpartList.add(watchpart);
            log.info("Added Watchpart");
        }
        catch (Exception e)
        {
            log.log(Level.SEVERE, "Failed to add watchpart", e);
            return false;
        }
        return true;
    }

    public boolean removeWatchpart(Watchpart watchpart)
    {
        try
        {
            watchpartList.remove(watchpart);
            log.info("Removed watchpart");
        }
        catch (Exception e)
        {
            log.log(Level.SEVERE, "Failed to add watchpart", e);
            return false;
        }
        return true;
    }

    public boolean setPrice(Watchpart watchpart, double newPrice)
    {
        try
        {
            watchpartList.remove(watchpart);
            watchpart.setPrice(newPrice);
            watchpartList.add(watchpart);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean setManufacturerID(Watchpart watchpart, Manufacturer manufacturer)
    {
        try
        {
            watchpartList.remove(watchpart);
            watchpart.setManufacturer(manufacturer);
            watchpartList.add(watchpart);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean setManufacturerPartID(Watchpart watchpart, String manufacturerPartID)
    {
        try
        {
            watchpartList.remove(watchpart);
            watchpart.setManufacturerPartID(manufacturerPartID);
            watchpartList.add(watchpart);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean setAmountAvailable(Watchpart watchpart, int amountAvailable)
    {
        try
        {
            watchpartList.remove(watchpart);
            watchpart.setAmountAvailable(amountAvailable);
            watchpartList.add(watchpart);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public int amountOfWatchparts()
    {
        return watchpartList.size();
    }

    protected void reset()
    {
        log.info("Cleared the class");
        watchpartList.clear();
    }
}
