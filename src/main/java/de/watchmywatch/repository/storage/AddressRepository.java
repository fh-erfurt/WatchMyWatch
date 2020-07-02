package de.watchmywatch.repository.storage;


import de.watchmywatch.model.Helper.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    }
