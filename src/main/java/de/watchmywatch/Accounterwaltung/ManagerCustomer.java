package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Exceptions.CustomerAlreadyExistsException;
import de.watchmywatch.Exceptions.CustomerDoesNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ManagerCustomer
{
    private List<Customer> customerList;
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ManagerCustomer()
    {
        customerList = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) throws CustomerAlreadyExistsException
    {
        if (customer != null)
        {
            if (!customerList.contains((customer)))
            {
                customerList.add(customer);
            } else
            {
                throw new CustomerAlreadyExistsException("Customer already Exists!");
            }
        } else
        {
            logger.warning("Given Customer is null...");
        }
    }

    public void removeCustomer(Customer customer) throws CustomerDoesNotExistException
    {
        if (customerList.contains(customer))
        {
            customerList.remove(customer);
        } else
        {
            logger.info("Given Customer does not exists!");
            throw new CustomerDoesNotExistException("Customer does not exist!");
        }

    }

    public List<Customer> getCustomerList()
    {
        return customerList;
    }
}
