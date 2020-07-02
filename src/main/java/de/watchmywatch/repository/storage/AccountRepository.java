package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
