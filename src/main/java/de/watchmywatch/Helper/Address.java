package de.watchmywatch.Helper;

/**
 * Class which represents an Address
 *
 * @author Anton Bespalov
 */
@Entity
public class Address extends DatabaseEntity
{
    @ManyToOne
    private String street;

    @ManyToOne
    private String city;

    @ManyToOne
    private String state;

    @ManyToOne
    private String zip;

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