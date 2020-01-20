package de.watchmywatch.Accounterwaltung;

public class Person
{
    private String email;
    private String addressID;
    private String phone;
    private String firstname;
    private String lastname;

    public Person(String email, String addressID, String phone, String firstname, String lastname)
    {
        this.email = email;
        this.addressID = addressID;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person()
    {

    }

    public String getEmail()
    {
        return this.email;
    }

    public String getAddressID()
    {
        return addressID;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setAddressID(String addressID)
    {
        this.addressID = addressID;
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
}
