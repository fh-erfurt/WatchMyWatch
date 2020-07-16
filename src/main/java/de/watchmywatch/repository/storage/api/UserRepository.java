package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.AccountManagment.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);

}
