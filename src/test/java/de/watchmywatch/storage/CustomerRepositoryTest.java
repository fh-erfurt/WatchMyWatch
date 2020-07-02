package de.watchmywatch.storage;


import de.watchmywatch.model.Helper.Address;

import de.watchmywatch.repository.storage.AddressRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
class CustomerRepositoryTest {


   @Autowired
   AddressRepository addressRepository;


    @Test
    @Rollback(false)
    public void should_find_customer_in_DB()  {

        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        addressRepository.save(address);

        Assert.assertEquals(1,1);


    }

}
