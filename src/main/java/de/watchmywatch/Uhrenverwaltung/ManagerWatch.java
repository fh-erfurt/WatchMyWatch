package de.watchmywatch.Uhrenverwaltung;


import java.math.BigDecimal;
import java.util.List;

public class ManagerWatch
{
    private static List<Watch> watchList;

    //adds a watch to the list but doesnt if the exact same watch is already present
    public void addWatch(Watch watch)
    {
        //if watch IS NOT in the list
        if (!watchList.contains(watch))
        {
            watchList.add(watch);
        } else
        {
            //TODO LOG output watch is already existing in the watchList
        }
    }

    public void removeWatch(Watch watch)
    {
        if (watchList.contains(watch))
        {
            watchList.remove(watch);
        } else
        {
            //TODO LOG output couldnt remove watch as it was not in the list
        }
    }

    public BigDecimal getPriceWithExtraCost()
    {
        return new BigDecimal(1);
    }

    public BigDecimal getPriceWithoutExtraCost()
    {
        return new BigDecimal(1);
    }
}
