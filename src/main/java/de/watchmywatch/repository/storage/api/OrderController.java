package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Payment;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/api")
public class OrderController {
    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public ShoppingcartRepository shoppingcartRepository;

    // GET /api/orders returns all orders
    @GetMapping(path = "/orders")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // GET /api/orders/:id returns order with id
    @GetMapping(value = "/orders/{orderId}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Order getOneOrder(@PathVariable Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("order", orderId));
    }

    // POST /api/orders creates an Order in the database and returns "Saved"
    @PostMapping(path = "/orders")
    public @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    Order addNewOrder(@RequestParam int addressId, @RequestParam int shoppingcartId) {
        Address address = addressRepository.findById(addressId).get();
        Shoppingcart shoppingcart = shoppingcartRepository.findById(shoppingcartId).get();

        Order order = new Order();

        order.setShippingAddress(address);
        order.setShoppingcart(shoppingcart);
        order.setPayment(new Payment());
        return orderRepository.save(order);
    }

    // PUT /api/orders/:id updates the order with the id
    @PutMapping("/orders/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Order updateOrder(@PathVariable Integer id, @RequestBody Order newOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setOrdered(newOrder.getOrdered());
                    order.setShipped(newOrder.getShipped());
                    order.setShippingAddress(newOrder.getShippingAddress());
                    order.setOrderStatus(newOrder.getOrderStatus());
                    order.setShippingStatus(newOrder.getShippingStatus());
                    order.setShoppingcart(newOrder.getShoppingcart());
                    // order.calcTotal();  Already done in setShoppingcart
                    order.setPayment(newOrder.getPayment());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return orderRepository.save(newOrder);
                });
    }

    // DELETE /api/orders/:id deletes the order with id and returns "Deleted"
    @DeleteMapping(path = "/orders/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateOrder(@PathVariable Integer id) {
        orderRepository.deleteById(id);
    }
}