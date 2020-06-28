package de.watchmywatch.repository.core;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Address, Integer> {

}
