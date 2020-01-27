package de.watchmywatch.Accounterwaltung;

import java.util.List;

public class ManagerCustomer
{
    private static List<Customer> customerList;

    //adds a customer to the list but doesnt if the exact same customer is already present
    public boolean addCustomer(Customer customer)
    {
        try
        {
            customerList.add(customer);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void removeCustomer(Customer customer)
    {
        if (customerList.contains(customer))
        {
            customerList.remove(customer);
        } else
        {
            //TODO output: Customer was not removed, not existing or nor found
        }

    }
}
