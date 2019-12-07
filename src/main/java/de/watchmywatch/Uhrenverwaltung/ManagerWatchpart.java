package de.watchmywatch.Uhrenverwaltung;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ManagerWatchpart
{
    private static Map<Integer, Watchpart> watchpartMap = new HashMap<Integer, Watchpart>();
    private static int idCounter = 1;

    public boolean addWatchpart(Watchpart watchpart)
    {
        try
        {
            watchpartMap.put(idCounter, watchpart);
            ++idCounter;
        }
        catch (Exception e)
        {
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
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean removeWatchpartByObject(Watchpart part)
    {
        try
        {
        }
        catch (Exception e)
        {
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
        System.out.println("Cleared class ");
        watchpartMap.clear();
        idCounter = 1;
    }
}
