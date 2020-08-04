package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.AccountManagment.User;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.PaymentMethod;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public ShoppingcartRepository shoppingcartRepository;

    @GetMapping(path = "/users", produces = "application/json")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    User getOneUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @PostMapping(path = "/users", produces = "application/json")
    public @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    User addUser(/*@RequestParam LocalDate dob, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email,
                 @RequestParam PaymentMethod paymentMethod, @RequestParam String phone, @RequestParam String password,
                 @RequestParam Integer addressId, @RequestParam Integer billingAddressId*/ @RequestBody User user) {

        user.setSecurePassword(passwordEncoder.encode(user.getSecurePassword()));
        user.setAddress(addressRepository.save(user.getAddress()));
        user.setBillingAddress(addressRepository.save(user.getBillingAddress()));
        user.setShoppingCart(shoppingcartRepository.save(new Shoppingcart()));
        user.setOrders(null);

        return userRepository.save(user);
    }

    // PUT /api/users/:id updates the user with the id
    @PutMapping(value = "/users/{id}", produces = "application/json")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    User updateUser(@RequestParam Integer id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setAddress(newUser.getAddress());
                    user.setDob(newUser.getDob());
                    user.setEmail(newUser.getEmail());
                    user.setFirstname(newUser.getFirstname());
                    user.setLastname(newUser.getLastname());
                    user.setPhone(newUser.getPhone());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    // DELETE /api/users/:id deletes the user with id
    @DeleteMapping(value = "/users/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
