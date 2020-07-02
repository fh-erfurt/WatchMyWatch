package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.Helper.DatabaseEntity;
import javax.persistence.*;



/**
 * Class which represents an Person
 *
 * @author Anton Bespalov
 */

@MappedSuperclass
public class Person extends DatabaseEntity
{

    @Column(unique=true)
    private String email;

    @ManyToOne(cascade= CascadeType.PERSIST)
    private Address address;

    private String phone;

    private String firstname;

    private String lastname;

    public Person() {
    }

    /**
     * @param email     the email from the person
     * @param address   the address of the person
     * @param phone     phonenumber from the person
     * @param firstname firstname from the person
     * @param lastname  lastname from the person
     * @author Anton Bespalov
     */

    public Person(String email, Address address, String phone, String firstname, String lastname)
    {
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

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
