package de.watchmywatch.model.Helper;
import javax.persistence.*;

/**
 * Class which represents an Address
 *
 * @author Anton Bespalov
 */
@Entity
public class Address extends DatabaseEntity
{

    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    /**
     * @param street street and housnumber
     * @param city   the city
     * @param state  the state
     * @param zip    the zip
     * @author Anton Bespalov
     */

    public Address(String street, String city, String state, String zip)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }
}