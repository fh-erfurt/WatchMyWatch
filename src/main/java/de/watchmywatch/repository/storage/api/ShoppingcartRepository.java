package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShoppingcartRepository extends CrudRepository<Shoppingcart, Integer> {
}
