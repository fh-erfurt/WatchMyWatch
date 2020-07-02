package de.watchmywatch.repository.core;

import de.watchmywatch.model.AccountManagment.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
