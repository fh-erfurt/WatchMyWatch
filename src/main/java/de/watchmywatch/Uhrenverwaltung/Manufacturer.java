package de.watchmywatch.Uhrenverwaltung;

import de.watchmywatch.Accounterwaltung.Person;

public class Manufacturer
{
    //move to manager class in hashmap
    //private int id;
    private String name;
    private Person contactPerson;
    private int addressID;
    //private static int idCounter = 0;

    public Manufacturer(String name, Person contactPerson, int addressID)
    {
        //move to manager class in hashmap
        //id = idCounter;
        //++idCounter;
        this.name = name;
        this.contactPerson = contactPerson;
        this.addressID = addressID;
    }

//    public int getID()
//    {
//        return id;
//    }

    public String getName()
    {
        return name;
    }

    public Person getContactPerson()
    {
        return contactPerson;
    }

    public int getAddressID()
    {
        return addressID;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setContactPerson(Person contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public void setAddressID(int addressID)
    {
        this.addressID = addressID;
    }
}