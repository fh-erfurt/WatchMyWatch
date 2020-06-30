package de.watchmywatch.repository.storage;


import de.watchmywatch.model.AccountManagment.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}
