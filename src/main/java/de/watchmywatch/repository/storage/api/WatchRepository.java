package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.WatchManagment.Watch;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WatchRepository extends CrudRepository<Watch, Integer> {
    Optional<Watch> findByName(String name);
}
