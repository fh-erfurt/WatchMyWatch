package de.watchmywatch.repository.exception;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.repository.core.DataController;
import de.watchmywatch.repository.core.IGenericDao;

public class JpaStorageController {
/*
    public AddressBook loadAddressbook() throws StorageException
    {
        IGenericDao<Person> personDao = DataController.getInstance().getPersonDao();
        Collection<Person> personsFromDatabase = personDao.findAll();
        return new AddressBook( new ArrayList<Person>( personsFromDatabase ) );
    }

    public void deletePersonFromAddressbook( Person person) throws StorageException
    {
        IGenericDao<Person> personDao = DataController.getInstance().getPersonDao();
        Person personsFromDatabase = personDao.findById(person.getId());
        if(personsFromDatabase != null)
        {
            personDao.delete(person.getId());
        }
        else{
            System.out.println("the Person is not in the Databank");
        }
    }

    public Person editPersonFromAddressbook( Person person,String firstName) throws StorageException
    {
        Person p = new Person();
        IGenericDao<Person> personDao = DataController.getInstance().getPersonDao();
        Person personsFromDatabase = personDao.findById(person.getId());

        if(personsFromDatabase != null)
        {
            personsFromDatabase.setFirstName(firstName);
            p = personDao.update(personsFromDatabase);
        }
        else{
            System.out.println("the Person is not in the Databank");
        }
        return p;
    }


    public void deleteTableFromAddressbook(List<Person> persons) throws StorageException
    {
        IGenericDao<Person> personDao = DataController.getInstance().getPersonDao();
        personDao.delete(persons);

    }*/


    public void saveCustomer(Customer customer ) throws StorageException
    {
        IGenericDao<Customer> customerDao = DataController.getInstance().getCustomerDao();

           // if( customer.getId() == null )
                customerDao.create( customer );


    }
}


