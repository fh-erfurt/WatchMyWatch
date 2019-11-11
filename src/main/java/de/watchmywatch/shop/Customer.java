package de.watchmywatch.shop;

public class Customer
{
    private String id;
    private String email;
    private Address address;
    private Phone phone;
    private String firstname;
    private String lastname;
    private Date dob;

    //setter methods

    //id should always be set by the constructor and never changed?!

    void setEmail(String email)
    {
        this.email = email;
    }

    void setAddress(Address address)
    {
        this.address = address;
    }

    void setPhone(Phone phone)
    {
        this.phone = phone;
    }

    void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    void setDob(Date dob)
    {
        this.dob = dob;
    }

    //getter methods
}
