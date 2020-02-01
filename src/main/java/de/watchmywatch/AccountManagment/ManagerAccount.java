package de.watchmywatch.AccountManagment;

import de.watchmywatch.Exceptions.AccountAlreadyExistsException;
import de.watchmywatch.Exceptions.AccountDoesNotExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ManagerAccount
{
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private List<Account> accountList;
    /**
     *
     * @author Anton Bespalov
     */

    public ManagerAccount()
    {
        accountList = new ArrayList<>();
    }

    public List<Account> getAccountList()
    {
        return accountList;
    }

    /**
     * addAccount function
     * @param account   account that should be added to the accountList
     * when the account is not null and is not in the list it will be added
     * if the account is already in the list an exception will be thrown
     * if the account is null a warning will be logged
     */
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
    /**
     * removeAccount function
     * @param account   account that should be removed from the accountList
     * if the account is in the list the account will be removed
     * if the account is not in the list an exception will be thrown
     */
    public void removeAccount(Account account) throws AccountDoesNotExistsException
    {
        if (accountList.contains(account))
        {
            accountList.remove(account);
        }
        else
        {
            logger.info("Given Account does not exists!");
            throw new AccountDoesNotExistsException("Account does not exist!");
        }
    }

    /**
     * removeAccount function
     * @param account   account that should be removed from the accountList
     * @param status    is the new account status
     * @return false, when the account status is already the same status or the account was not found in the accountList / true, when the new account status was set
     * if the account was found and the status is not the same as the new status, the accountStatus will be changed
     * if the account is not in the list a warning will be logged
     */
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
            logger.warning("Given Account was not found");
        }
        return false;
    }
}
