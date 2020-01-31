package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Exceptions.AccountAlreadyExistsException;
import de.watchmywatch.Exceptions.AccountDoesNotExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ManagerAccount
{

    private List<Account> accountList;
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ManagerAccount()
    {
        accountList = new ArrayList<Account>();
    }

    public List<Account> getAccountList()
    {
        return accountList;
    }

    public void addAccount(Account account) throws AccountAlreadyExistsException
    {
        if (account != null)
        {
            if (!accountList.contains((account)))
            {
                accountList.add(account);
            }
            else
            {
                throw new AccountAlreadyExistsException("Account already Exists!");
            }
        }
        else
        {
            logger.warning("Given Account is null...");
        }
    }

    public void removeAccount(Account account) throws AccountDoesNotExistsException
    {
        if (accountList.contains(account))
        {
            accountList.remove(account);
        }
        else
        {
            throw new AccountDoesNotExistsException("Account does not exist!");
        }
    }

    public boolean changeAccountStatus(Account account, AccountStatus status)
    {
        if (accountList.contains(account))
        {
            if (account.getAccountStatus() == status)
            {
                logger.info("Given Status is the same.");
                return false;
            }
            else
            {
                account.setAccountStatus(status);
                return true;
            }
        }
        else
        {
            logger.warning("Given Account is null...");
        }
        return false;
    }
}
