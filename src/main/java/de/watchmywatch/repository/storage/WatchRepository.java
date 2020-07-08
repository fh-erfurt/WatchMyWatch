package de.watchmywatch.repository.storage;

import de.watchmywatch.model.WatchManagment.Bracelet;
import de.watchmywatch.model.WatchManagment.Casing;
import de.watchmywatch.model.WatchManagment.Clockwork;
import de.watchmywatch.model.WatchManagment.Watch;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WatchRepository extends CrudRepository<Watch, Integer> {
    Optional<Bracelet> findBraceletById(int id);
    Optional<Casing> findCasingById(int id);
    Optional<Clockwork> findClockworkById(int id);
}
