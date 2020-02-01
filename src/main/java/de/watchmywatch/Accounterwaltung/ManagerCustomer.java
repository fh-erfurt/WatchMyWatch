package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Exceptions.CustomerAlreadyExistsException;
import de.watchmywatch.Exceptions.CustomerDoesNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ManagerCustomer
{
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private List<Customer> customerList;
    /**
     *
     * @author Anton Bespalov
     */
    public ManagerCustomer()
    {
        customerList = new ArrayList<>();
    }

    /**
     * addAccount function
     * @param customer   customer that should be added to the customerList
     * when the customer is not null and is not in the list it will be added
     * if the customer is already in the list an exception will be thrown
     * if the customer is null a warning will be logged
     */
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
    /**
     * removeAccount function
     * @param customer   customer that should be removed from the customerList
     * if the customer is in the list the customer will be removed
     * if the customer is not in the list an exception will be thrown
     */
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
