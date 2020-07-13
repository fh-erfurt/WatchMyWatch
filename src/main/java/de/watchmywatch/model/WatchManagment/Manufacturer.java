package de.watchmywatch.model.WatchManagment;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.Helper.DatabaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.logging.Logger;

/**
 * class which represents a manufacturer
 * @author Tom Käppler
 */
@Entity
public class Manufacturer extends DatabaseEntity
{
    private transient Logger logger = Logger.getLogger("Logger");

    @ApiModelProperty(notes = "The name of the manufacturer.")
    private String name;

    @ApiModelProperty(notes = "The contact person of this manufacturer.")
    @OneToOne
    private Customer contactPerson;

    @ApiModelProperty(notes = "The address of the manufacturer.")
    @ManyToOne(cascade= CascadeType.PERSIST)
    private Address address;

    /**
     * creates a manufacturer object
     * @param name          Name des Herstellers
     * @param contactPerson Objekt unserer KontatPerson
     * @param address       Hauptadresse des Herstellers
     * @author Tom Käppler
     */
    public Manufacturer(String name, Customer contactPerson, Address address)
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

    public Customer getContactPerson()
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

    public void setContactPerson(Customer contactPerson)
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
