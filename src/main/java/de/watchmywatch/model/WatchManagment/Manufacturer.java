package de.watchmywatch.model.WatchManagment;

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
    private String contactEmail;

    private String contactPhone;

    @ApiModelProperty(notes = "The address of the manufacturer.")
    @ManyToOne(cascade= CascadeType.PERSIST)
    private Address address;

    public Manufacturer(String name, String contactEmail, String contactPhone, Address address) {
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.address = address;
    }

    /**
     * creates a manufacturer object
     * @param name          Name des Herstellers
     * @param contactEmail Objekt unserer KontatPerson
     * @param address       Hauptadresse des Herstellers
     * @author Tom Käppler
     */


    protected Manufacturer(){}

    public String getName()
    {
        return name;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }


    public void setAddress(Address address)
    {
        this.address = address;
        //logger.info("address was set");
    }
}
