package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.Helper.DatabaseEntity;
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
public class Customer extends DatabaseEntity {
    
    @Column(unique = true)
    private String email;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    private String phone;

    private String firstname;

    private String lastname;

    private Date dob;

    public Customer() {

    }

    /**
     * @param email     the email from the person
     * @param address   the address of the person
     * @param phone     phonenumber from the person
     * @param firstname firstname from the person
     * @param lastname  lastname from the person
     * @param dob       the date of birth from the customer
     * @author Anton Bespalov
     */

    public Customer(String email, Address address, String phone, String firstname, String lastname, Date dob) {
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
