package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Watchpart;
import de.watchmywatch.Uhrenverwaltung.ConnectionType;
import de.watchmywatch.Uhrenverwaltung.Material;
import de.watchmywatch.Uhrenverwaltung.PartType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ManagerWatchpart
{
    //TODO is HashMap the right MultiMap
    private static Map<Integer, Watchpart> watchparts = new HashMap<Integer, Watchpart>();
    private static int idCounter = 1;

    public boolean addWatchpart(Watchpart watchpart)
    {
        //TODO What should happen if the exact same Watchpart is already there
        //Should we even check if the exactly same Watchpart is already instanciated?
        try
        {
            watchparts.put(idCounter, watchpart);
            ++idCounter;
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean removeWatchpartByID(Integer id)
    {
        try
        {
            watchparts.remove(id);
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
            watchparts.get(id).setPrice(newPrice);
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
            watchparts.get(id).setManufacturerID(manufacturerID);
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
            watchparts.get(id).setManufacturerPartId(manufacturerPartID);
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
            watchparts.get(id).setAmountAvailable(amountAvailable);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
