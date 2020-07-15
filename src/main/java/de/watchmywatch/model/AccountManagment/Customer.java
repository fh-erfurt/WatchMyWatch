package de.watchmywatch.model.AccountManagment;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.Helper.DatabaseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;


import javax.persistence.*;
import java.time.LocalDate;

/**
 * Class which represents an Customer
 *
 * @author Anton Bespalov
 */

@Entity
public class Customer extends DatabaseEntity {
    
    @Column(unique = true)
    @NotNull
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @NotNull
    @NotBlank( message = "Require")
    private String phone;

    @NotNull
    @Size(min=3, max = 7, message = "Firstname must be 2-35 characters long.")
    private String firstname;

    @NotNull
    @Size(min = 2, max = 35, message = "Lastname must be 2-35 characters long.")
    private String lastname;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

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

    public Customer(String email, Address address, String phone, String firstname, String lastname, LocalDate dob) {
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
    }



    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
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
