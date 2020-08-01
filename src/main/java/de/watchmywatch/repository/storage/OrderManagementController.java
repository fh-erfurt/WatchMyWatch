package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.AccountStatus;
import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Payment;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.repository.storage.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLOutput;
import java.util.Optional;

@Controller
public class OrderManagementController {

    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public PaymentRepository paymentRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public ShoppingcartRepository shoppingcartRepository;

    @PostMapping(path = "/newOrder")
    public String addNewOrder(@ModelAttribute("newPayment") Payment newPayment,
                              Authentication authentication) throws ShoppingcartEmptyException {
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        Shoppingcart shoppingcart = user.get().getShoppingCart();
        shoppingcart.calcTotal();    // TODO: Remove when DB is consistent/clear and filled by API's
        Address address = user.get().getAddress();

        Order saveOrder = new Order(address, shoppingcart, user.get());
        saveOrder.getPayment().setPaymentMethod(newPayment.getPaymentMethod());
        orderRepository.save(saveOrder);
        user.get().setShoppingCart(shoppingcartRepository.save(new Shoppingcart()));
        userRepository.save(user.get());

        return "redirect:/order";
    }
}
