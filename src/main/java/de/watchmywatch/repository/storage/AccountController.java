package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api") // This means URL's start with /demo (after Application path)
public class AccountController {

    @Autowired
    public AccountRepository accountRepository;

    @GetMapping(path="/accounts")
    public @ResponseBody Iterable<Account> getAllAccounts() {
        // This returns a JSON or XML with the users
        return accountRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody void addAccount(Account account){
        accountRepository.save(account);
    }
//HH
}
