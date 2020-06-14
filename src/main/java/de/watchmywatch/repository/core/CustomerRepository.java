package de.watchmywatch.repository.core;

import de.watchmywatch.model.AccountManagment.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
