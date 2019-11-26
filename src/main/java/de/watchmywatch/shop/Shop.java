package de.watchmywatch.shop;

import java.util.List;
import java.util.Map

public class Shop {
    private List<Account> accounts;
    private List<Watch> watches;
    private Map<partType, Watchpart> watchparts;
    private Map<addressID, Address> adresses;
    private List<Order> orders;
    private List<Manufacturer> manufacturers;
    private List<Person> persons;
    private List<Customer> customers;
}
