package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Helper.Address;

public class Person
{
    private String email;
    private Address address;
    private String phone;
    private String firstname;
    private String lastname;

    public Person(String email, Address address, String phone, String firstname, String lastname)
    {
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void deletePerson(){}

    public String getEmail()
    {
        return this.email;
    }


    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }
    public Address getAddress()
    {
        return address;
    }
    public String getPhone()
    {
        return phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

}
