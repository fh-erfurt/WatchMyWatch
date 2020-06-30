package de.watchmywatch.repository.storage;


import de.watchmywatch.model.Helper.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface AddressRepository extends CrudRepository<Address, Integer> {

    }
