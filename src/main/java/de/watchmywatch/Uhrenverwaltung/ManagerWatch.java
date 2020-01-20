package de.watchmywatch.Uhrenverwaltung;

import java.util.ArrayList;

public class ManagerWatch
{
    private static ArrayList<Watch> watchList = new ArrayList<>();

    //adds a watch to the list but doesnt if the exact same watch is already present
    public void addWatch(Watch watch)
    {
        if (watch.validate())
        {
            //if watch IS NOT in the list
            if (!watchList.contains(watch))
            {
                watchList.add(watch);
            } else
            {
                //TODO LOG output watch is already existing in the watchList
            }
        } else
        {
            //TODO LOG that watch wasnt valid and maybe throw an exception
        }
    }

    //returns null if watch doesnt get found
    public Watch getWatch(int i)
    {
        //if watch IS NOT in the list
        if (watchList.get(i) != null)
        {
            return watchList.get(i);
        } else
        {
            //TODO LOG output watch is not in list
            return null;
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
}
