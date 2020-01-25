package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Uhrenverwaltung.Validator.Validator;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ManagerWatch
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static ArrayList<Watch> watchList = new ArrayList<>();

    //adds a watch to the list but doesnt if the exact same watch is already present
    public void addWatch(Watch watch)
    {
        if (watch.validate())
        {
            watchList.add(watch);
            logger.info("watch was added");
        }
        else
        {
            logger.warning("watch was not valid -> was not added");
        }
    }

    //returns null if watch doesnt get found
    public Watch getWatch(int i)
    {
        //if watch IS NOT in the list
        if (watchList.get(i) != null)
        {
            return watchList.get(i);
        }
        else
        {
            logger.warning("watch was not found");
            return null;
        }
    }

    public void removeWatch(Watch watch)
    {
        if (watchList.contains(watch))
        {
            watchList.remove(watch);
            logger.info("watch was removed");
        }
        else
        {
            logger.warning("watch was not found -> not removed");
        }
    }
}
