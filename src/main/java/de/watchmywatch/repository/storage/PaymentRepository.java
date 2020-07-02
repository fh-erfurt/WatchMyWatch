package de.watchmywatch.repository.storage;

import de.watchmywatch.model.OrderManagment.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
