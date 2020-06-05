package io.jonashackt.lectures.exercises.model.WatchManagment;

import io.jonashackt.lectures.exercises.model.Address;
import io.jonashackt.lectures.exercises.model.Helper.AbstractDatabaseEntity;
import io.jonashackt.lectures.exercises.model.Person;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.logging.Logger;

/**
 * class which represents a manufacturer
 * @author Tom Käppler
 */
@Entity
public class Manufacturer extends AbstractDatabaseEntity
{
    //Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private String name;
    @ManyToOne
    private Person contactPerson;
    @ManyToOne
    private Address address;

    /**
     * creates a manufacturer object
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

    protected Manufacturer(){}

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
        //logger.info("name was set");
    }

    public void setContactPerson(Person contactPerson)
    {
        this.contactPerson = contactPerson;
        //logger.info("contactPerson was set");
    }

    public void setAddress(Address address)
    {
        this.address = address;
        //logger.info("address was set");
    }
}
