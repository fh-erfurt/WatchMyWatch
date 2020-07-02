package de.watchmywatch.repository.storage;

import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingcartRepository extends CrudRepository<Shoppingcart, Integer> {
}
