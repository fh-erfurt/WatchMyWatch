package de.watchmywatch.Uhrenverwaltung;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * class which contains a list of watches for further use
 * @author Tom Käppler
 */
public class ManagerWatch
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static ArrayList<Watch> watchList = new ArrayList<>();

    /**
     * validates a watch and then adds it to the list
     * @param watch watch which should be added
     */
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

    /**
     * returns a arrayList of the watches found with that name
     * @param watchName name of the watch which is searched
     * @return arrayList of watches
     */
    public ArrayList<Watch> getWatch(String watchName)
    {
        ArrayList<Watch> returnList = new ArrayList<>();
        for (Watch watch : watchList){
            if(watch.getName() == watchName){
                returnList.add(watch);
                logger.info("watch found with that name");
            }
        }
        return returnList;
    }

    /**
     * removes a watch from the list
     * @param watch the watch which should be removed
     */
    public void removeWatch(Watch watch)
    {
        if (watchList.contains(watch))
        {
            watchList.remove(watch);
            logger.info("watch removed");
        }
        else
        {
            logger.warning("watch was not found -> not removed");
        }
    }

    /**
     * removes every watch from the list with the name
     * @param watchName name of the watch which should be removed
     */
    public void removeWatchByName(String watchName)
    {
        for (Watch watch : watchList){
            if(watch.getName() == watchName){
                watchList.remove(watch);
                logger.info("watch removed");
            }
        }
    }
}
