package de.watchmywatch.repository.storage;

import de.watchmywatch.model.OrderManagment.Shoppingcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // Identifies Class as Controller
@RequestMapping(path="/api") // URL's start with /demo (after Application path)
public class ShoppingcartController {
    @Autowired // This means to get the bean called ShoppingcartRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    public ShoppingcartRepository shoppingcartRepository;


    @PostMapping(path="/shoppingcart") // Map ONLY POST Requests
    public @ResponseBody String addNewShoppingcart (Shoppingcart shoppingcart) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        // TODO: Testing should be done in a different file/class ...
        // Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        // Shoppingcart testShoppingcart = new Shoppingcart();

        shoppingcartRepository.save(shoppingcart);
        return "Saved";
    }


    @GetMapping(path="/shoppingcarts")
    public @ResponseBody Iterable<Shoppingcart> getAllShoppingcarts() {
        // This returns a JSON or XML with the users
        return shoppingcartRepository.findAll();
    }

    @GetMapping(value="/shoppingcart/{shoppingcartId}")
    public @ResponseBody Optional<Shoppingcart> getOneShoppingcart(@PathVariable Integer  shoppingcartId) {
        // This returns a JSON or XML with the one shoppingcart

        return shoppingcartRepository.findById(shoppingcartId);
    }
}
