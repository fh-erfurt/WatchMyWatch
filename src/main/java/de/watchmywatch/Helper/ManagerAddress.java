package de.watchmywatch.Helper;

import de.watchmywatch.Exceptions.AddressAlreadyExistsException;
import de.watchmywatch.Exceptions.AddressDoesNotExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ManagerAddress
{
    private static List<Address> addressList;
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ManagerAddress()
    {
        addressList = new ArrayList<Address>();
    }

    public List<Address> getAddressList()
    {
        return addressList;
    }

    public void addAddress(Address address) throws AddressAlreadyExistsException
    {
        if (address != null)
        {
            if (!addressList.contains((address)))
            {
                addressList.add(address);
            }
            else
            {
                throw new AddressAlreadyExistsException("Address already Exists!");
            }
        }
        else
        {
            logger.warning("Given Address is null...");
        }
    }

    public void removeAddress(Address address) throws AddressDoesNotExistsException
    {
        if (addressList.contains(address))
        {
            addressList.remove(address);
        }
        else
        {
            throw new AddressDoesNotExistsException("Address does not exist!");
        }
    }
}
