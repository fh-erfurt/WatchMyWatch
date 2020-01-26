package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;
import de.watchmywatch.Helper.Address;

public class Manufacturer
{
    private String name;
    private Person contactPerson;
    private Address address;

    /**
     * Erzeugt ein Objekt eines Herstellers
     *
     * @author Tom Käppler
     * @param name Name des Herstellers
     * @param contactPerson Objekt unserer KontatPerson
     * @param address Hauptadresse des Herstellers
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
    }

    public void setContactPerson(Person contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public void setAddressID(Address address)
    {
        this.address = address;
    }
}
