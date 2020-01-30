package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * class which contains a list of manufacturers for further use
 *
 * @author Tom Käppler
 */
public class ManagerManufacturer
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private ArrayList<Manufacturer> manufacturerList = new ArrayList<>();

    /**
     * use if you already have a manufacturer Object
     *
     * @param manufacturer already created manufacturer
     * @return true - manufacturer was added / false - manufacturer was not added
     */
    public boolean addManufacturer(Manufacturer manufacturer)
    {
        try
        {
            manufacturerList.add(manufacturer);
            logger.info("manufacturer added");
        }
        catch (Exception e)
        {
            logger.warning("manufacturer was not added");
            return false;
        }
        return true;
    }

    /**
     * use if you just have the manufacturer infos but no object
     *
     * @param name          name of the manufacturer
     * @param contactPerson Person object of the contact
     * @param address       Address object of the headquarter
     * @return true - manufacturer was added / false - manufacturer was not added
     */
    public boolean addManufacturer(String name, Person contactPerson, Address address)
    {
        try
        {
            manufacturerList.add(new Manufacturer(name, contactPerson, address));
            logger.info("manufacturer added");
        }
        catch (Exception e)
        {
            logger.warning("manufacturer was not added");
            return false;
        }
        return true;
    }

    /**
     * returns the manufacturers found with that name
     * @param manufacturerName name of the manufacturer which is searched
     * @return Manufacturer
     */
    public Manufacturer getManufacturerByName(String manufacturerName)
    {
        for (Manufacturer manufacturer : manufacturerList){
            if(manufacturer.getName() == manufacturerName){
                logger.info("watch found with that name");
                return manufacturer;
            }
        }
        return null;
    }

    /**
     * removes a manufacturer from the list
     *
     * @param name name of the manufacturer which should be removed
     * @return true - manufacturer was removed / false - manufacturer was not removed
     */
    public boolean removeManufacturerByName(String name)
    {
        boolean success = false;
        try
        {
            for (Manufacturer manufacturer : manufacturerList)
            {
                if (manufacturer.getName() == name)
                {
                    manufacturerList.remove(manufacturer);
                    success = true;
                    logger.info("manufacturer removed");
                }
            }
        }
        catch (Exception e)
        {
            logger.warning("manufacturer was not removed");
            return success;
        }
        return success;
    }

    public int amountOfManufacturers()
    {
        return manufacturerList.size();
    }
}
