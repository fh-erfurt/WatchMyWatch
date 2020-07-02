package de.watchmywatch.repository.storage;

import de.watchmywatch.model.OrderManagment.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
