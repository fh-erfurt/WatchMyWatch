package de.watchmywatch.WatchManagment;

import de.watchmywatch.AccountManagment.Person;
import de.watchmywatch.Helper.Address;

import java.util.logging.Logger;

/**
 * class which represents a manufacturer
 * @author Tom Käppler
 */
public class Manufacturer
{
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private String name;
    private Person contactPerson;
    private Address address;

    /**
     * @param name          Name des Herstellers
     * @param contactPerson Objekt unserer KontatPerson
     * @param address       Hauptadresse des Herstellers
     * @author Tom Käppler
     */
    public Manufacturer(String name, Person contactPerson, Address address)
    {
        this.name = name;
        this.contactPerson = contactPerson;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public Person getContactPerson()
    {
        return contactPerson;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setName(String name)
    {
        this.name = name;
        logger.info("name was set");
    }

    public void setContactPerson(Person contactPerson)
    {
        this.contactPerson = contactPerson;
        logger.info("contactPerson was set");
    }

    public void setAddress(Address address)
    {
        this.address = address;
        logger.info("address was set");
    }
}
