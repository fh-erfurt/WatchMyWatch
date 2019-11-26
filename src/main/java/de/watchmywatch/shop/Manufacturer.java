package de.watchmywatch.shop;

public class Manufacturer
{
    private String id;
    private String name;
    private Person contactPerson;
    private String addressID;

    public String getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Person getContactPerson()
    {
        return contactPerson;
    }

    public String getAddressID()
    {
        return addressID;
    }

    //TODO should ID be autocreated -> autoincrement
    public void setID(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setContactPerson(Person contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public void setAddressID(String addressID)
    {
        this.addressID = addressID;
    }
}
