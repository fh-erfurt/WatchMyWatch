package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.AccountManagment.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @GetMapping(path = "/users")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(value="/users/{id}")
    public @ResponseBody
    Optional<User> getOneUser(@PathVariable Integer  userId) {
        // This returns a JSON or XML with the one user

        return userRepository.findById(userId);
    }

    @PostMapping(path = "/users")
    public @ResponseBody
    String addUser(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email) {
        //Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        //User customer = new User(email, address, "01716181447", firstname, lastname, LocalDate.of(1998, 9, 23));

       // User user = new User(customer, "Salami", address, new Date(2020, Calendar.JANUARY, 26), PAYPAL, ACTIV, new Shoppingcart());
        //userRepository.save(user);
        return "banana";
    }

    // PUT /api/users/:id updates the user with the id
    @PutMapping("/users/{id}")
    public @ResponseBody
    User updateUser(@PathVariable Integer id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user-> {
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
    @DeleteMapping("/users/{id}")
    public @ResponseBody
    String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "Deleted";
    }

}
