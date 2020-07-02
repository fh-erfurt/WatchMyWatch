package de.watchmywatch.repository.storage;

import de.watchmywatch.model.OrderManagment.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // Identifies Class as Controller
@RequestMapping(path="/api") // URL's start with /demo (after Application path)
public class OrderController {
    @Autowired // This means to get the bean called OrderRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    public OrderRepository orderRepository;


    @PostMapping(path="/order") // Map ONLY POST Requests
    public @ResponseBody String addNewOrder (Order order) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        // TODO: Testing should be done in a different file/class ...
        // Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        // Order testOrder = new Order();

        orderRepository.save(order);
        return "Saved";
    }


    @GetMapping(path="/orders")
    public @ResponseBody Iterable<Order> getAllOrders() {
        // This returns a JSON or XML with the users
        return orderRepository.findAll();
    }

    @GetMapping(value="/order/{orderId}")
    public @ResponseBody Optional<Order> getOneOrder(@PathVariable Integer  orderId) {
        // This returns a JSON or XML with the one order

        return orderRepository.findById(orderId);
    }
}