package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
