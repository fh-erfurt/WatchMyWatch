package de.watchmywatch.repository.core;

import de.watchmywatch.model.AccountManagment.Account;
import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.Helper.Address;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataController {

    private static final String PERSISTENCE_UNIT_NAME ="watch-my-watch";
    private EntityManagerFactory entityManagerFactory;
    private static DataController instance;

    public static DataController getInstance()
    {
        if( instance == null )
            instance = new DataController();
        return instance;
    }

    public DataController()
    {
        this.entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
    }

    public IGenericDao<Customer> getCustomerDao()
    {
        return new JpaGenericDao<Customer, Long>( Customer.class,this.entityManagerFactory.createEntityManager() );
    }

    public IGenericDao<Address>getAddressDao()
    {
        return new JpaGenericDao<Address, Long>( Address.class, this.entityManagerFactory.createEntityManager() );
    }

    public IGenericDao<Account> getAccountDao()
    {
        return new JpaGenericDao<Account, Long>( Account.class,this.entityManagerFactory.createEntityManager() );
    }
    public IGenericDao<Order> getOrderDao()
    {
        return new JpaGenericDao<Order, Long>( Order.class,this.entityManagerFactory.createEntityManager() );
    }
}
