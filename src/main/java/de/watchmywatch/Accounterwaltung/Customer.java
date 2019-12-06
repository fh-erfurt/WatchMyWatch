package de.watchmywatch.Accounterwaltung;

import java.util.Date;

public class Customer extends Person
{
    private Date dob;

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }


}
