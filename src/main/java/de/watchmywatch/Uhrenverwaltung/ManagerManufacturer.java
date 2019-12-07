package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;

import java.util.HashMap;
import java.util.Map;

public class ManagerManufacturer
{
    private static Map<Integer, Manufacturer> manufacturers = new HashMap<Integer, Manufacturer>();
    private static int idCounter = 1;

    public int howManyManufacturers()
    {
        int i = 0;
        for (Map.Entry<Integer, Manufacturer> entry : manufacturers.entrySet())
        {
            ++i;
        }
        return i;
    }

    //use if you already have a manufacturer Object
    public boolean addManufacturer(Manufacturer manufacturer)
    {
        try
        {
            manufacturers.put(idCounter, manufacturer);
            ++idCounter;
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    //use if you just have the manufacturer infos but no object
    public boolean addManufacturer(String name, Person contactPerson, int addressID)
    {
        try
        {
            manufacturers.put(idCounter, new Manufacturer(name, contactPerson, addressID));
            ++idCounter;
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean removeManufacturerByID(int id)
    {
        try
        {
            manufacturers.remove(id);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    //removes EVERY manufacturer with that name
    public boolean removeManufacturerByName(String name)
    {
        try
        {
            for (Map.Entry<Integer, Manufacturer> entry : manufacturers.entrySet())
            {
                if (entry.getValue().getName().equals(name))
                {
                    manufacturers.remove(entry.getKey());
                }
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    //return null if no manufacturer is found
    public Manufacturer getManufacturerByID(int id)
    {
        try
        {
            return manufacturers.get(id);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    //returns -1 if no manufacturer is found
    //returns the first ID which is found
    public int getManufacturerIDByName(String name)
    {
        try
        {
            for (Map.Entry<Integer, Manufacturer> entry : manufacturers.entrySet())
            {
                if (entry.getValue().getName().equals(name))
                {
                    return entry.getKey();
                }
            }
        }
        catch (Exception e)
        {
            return -1;
        }
        return -1;
    }

    public boolean updateContactPersonByID(int id, Person contactPerson)
    {
        try
        {
            manufacturers.get(id).setContactPerson(contactPerson);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean updateAddressByID(int id, int addressID)
    {
        try
        {
            manufacturers.get(id).setAddressID(addressID);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
