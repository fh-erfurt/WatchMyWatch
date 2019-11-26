package de.watchmywatch.classes;

import java.util.List;
import java.util.Map;

public abstract class Shop {
    private List<Account> accounts;
    private List<Watch> watches;
    private Map<PartType, Watchpart> watchparts;
    private Map<Integer, Address> adresses;
    private List<Order> orders;
    private List<Manufacturer> manufacturers;
    private List<Person> persons;
    private List<Customer> customers;

    // returns true, if it add the account to the list
    public boolean addAccount(Account account) {
        boolean temp = false;
        temp = accounts.add(account);
        return temp;
    }
}
