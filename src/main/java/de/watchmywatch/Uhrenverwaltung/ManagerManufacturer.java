package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;

import java.util.ArrayList;


public class ManagerManufacturer
{
    private static ArrayList<Manufacturer> manufacturerList = new ArrayList<>();

    //use if you already have a manufacturer Object
    public boolean addManufacturer(Manufacturer manufacturer)
    {
        try
        {
            manufacturerList.add(manufacturer);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    //use if you just have the manufacturer infos but no object
    public boolean addManufacturer(String name, Person contactPerson, Address address)
    {
        try
        {
            manufacturerList.add(new Manufacturer(name, contactPerson, address));
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
            manufacturerList.remove(id);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
