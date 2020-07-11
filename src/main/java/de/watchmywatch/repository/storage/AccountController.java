package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.Account;
import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.model.WatchManagment.*;
import de.watchmywatch.repository.exception.JpaStorageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static de.watchmywatch.model.AccountManagment.AccountStatus.ACTIV;
import static de.watchmywatch.model.OrderManagment.PaymentMethod.PAYPAL;

@Controller
@RequestMapping(path = "/api") // This means URL's start with /demo (after Application path)
public class AccountController {

    @Autowired
    public AccountRepository accountRepository;

    @GetMapping(path = "/accounts")
    public @ResponseBody
    Iterable<Account> getAllAccounts() {
        // This returns a JSON or XML with the users
        return accountRepository.findAll();
    }

    @PostMapping(path = "/create")
    public @ResponseBody
    String addAccount(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email) {
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        Customer customer = new Customer(email, address, "01716181447", firstname, lastname, new Date(1998, Calendar.SEPTEMBER, 23));

        Account account = new Account(customer, "Salami", address, new Date(2020, Calendar.JANUARY, 26), PAYPAL, ACTIV, new Shoppingcart());
        accountRepository.save(account);
        return "banana";
    }
    @GetMapping(value="/accounts/{accountId}")
    public @ResponseBody
    Optional<Account> getOneCustomer(@PathVariable Integer  accountId) {
        // This returns a JSON or XML with the one user

        return accountRepository.findById(accountId);
    }
    // PUT /api/accounts/:id updates the accounts with the id
    @PutMapping("/accounts/{id}")
    public @ResponseBody
    Account updateAccount(@PathVariable Integer id, @RequestBody Account newAccount) {
        return accountRepository.findById(id)
                .map(account -> {
                    account.setCustomer(newAccount.getCustomer());
                    account.setAccountStatus(newAccount.getAccountStatus());
                    account.setBillingAddress(newAccount.getBillingAddress());
                    account.setSecurePassword(newAccount.getSecurePassword());
                    account.setPaymentMethod(newAccount.getPaymentMethod());
                    account.setOpened(newAccount.getOpened());
                    account.setOrders(newAccount.getOrders());
                    account.setShoppingCart(newAccount.getShoppingCart());
                    return accountRepository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return accountRepository.save(newAccount);
                });
    }
}

