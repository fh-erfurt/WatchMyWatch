package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.Address;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.util.Date;

/**
 * Class which represents an Customer
 *
 * @author Anton Bespalov
 */

@Entity
public class Customer extends Person
{
    private Date dob;

    public Customer() {

    }

    /**
     * @param dob the date of birth from the customer
     * @author Anton Bespalov
     */


    public Customer(String email, Address address, String phone, String firstname, String lastname, Date dob)
    {
        super(email, address, phone, firstname, lastname);
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
