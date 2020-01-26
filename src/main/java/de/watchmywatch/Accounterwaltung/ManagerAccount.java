package de.watchmywatch.Accounterwaltung;

import java.util.List;

public class ManagerAccount {

    private static List<Account> accountList;

    public static void addAccount(Account account)
    {
        if(!accountList.contains(account))
        {
            accountList.add(account);
        }
        else
        {

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
