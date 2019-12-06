package de.watchmywatch.Accounterwaltung;

public class Person
{
    private String id;
    private String email;
    private String addressID;
    private String phone;
    private String firstname;
    private String lastname;

    public void updateEmailById(String id, String newEmail)
    {
    }

    public void updateAddressIdById(String id, String newAddressId)
    {
    }

    public void updatePhoneById(String id, String newPhone)
    {
    }

    public String getId()
    {
        return this.id;
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

    public void setId(String id)
    {
        this.id = id;
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
