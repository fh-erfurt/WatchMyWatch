package de.watchmywatch.repository.storage.api;


import de.watchmywatch.model.AccountManagment.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}
