package de.watchmywatch.repository.storage.api;


import de.watchmywatch.model.Helper.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    }
