package de.watchmywatch.Accounterwaltung;

import java.util.Date;

public class Customer extends Person
{
    private Date dob;

    public Customer(String email, String addressID, String phone, String firstname, String lastname, Date dob)
    {
        super(email, addressID, phone, firstname, lastname);
        this.dob = dob;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }


}
