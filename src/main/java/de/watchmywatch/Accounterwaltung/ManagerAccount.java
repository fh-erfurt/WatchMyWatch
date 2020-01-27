package de.watchmywatch.Accounterwaltung;

import de.watchmywatch.Exceptions.AccountAlreadyExistsException;

import java.util.List;

public class ManagerAccount {

    private static List<Account> accountList;


    public static void addAccount(Account account) throws AccountAlreadyExistsException
    {
        if(!accountList.contains((account)))
        {
            accountList.add(account);
        }
       else
        {
            throw new AccountAlreadyExistsException("Account already Exists!");
        }
    }
    public static void removeAccount(Account account)
    {
        if(accountList.contains(account))
        {
            accountList.remove(account);
        }
        else
        {
            // TODO output: account removal failed, account doesnt exists or was not found
        }
    }
}
