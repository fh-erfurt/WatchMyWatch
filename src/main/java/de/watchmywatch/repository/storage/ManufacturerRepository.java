package de.watchmywatch.repository.storage;

import de.watchmywatch.model.WatchManagment.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

}
