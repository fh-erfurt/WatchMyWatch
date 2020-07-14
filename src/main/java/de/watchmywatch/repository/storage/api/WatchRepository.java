package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.WatchManagment.Watch;
import org.springframework.data.repository.CrudRepository;

public interface WatchRepository extends CrudRepository<Watch, Integer> {
}
