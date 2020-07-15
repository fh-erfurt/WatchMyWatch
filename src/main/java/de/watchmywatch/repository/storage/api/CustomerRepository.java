package de.watchmywatch.repository.storage.api;


import de.watchmywatch.model.AccountManagment.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}
