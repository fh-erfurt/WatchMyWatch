package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.AccountStatus;
import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import de.watchmywatch.model.OrderManagment.Payment;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.repository.storage.api.AddressRepository;
import de.watchmywatch.repository.storage.api.OrderRepository;
import de.watchmywatch.repository.storage.api.PaymentRepository;
import de.watchmywatch.repository.storage.api.ShoppingcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(path = "/newOrder")
    public String addNewOrder(@ModelAttribute("newOrder") Order newOrder,
                              @ModelAttribute("newPayment") Payment newPayment,
                              Model model) {
       Order order = newOrder;


//        orderRepository.save(newOrder);
//        newUser.setAddress(newAddress);
//        orderRepository.save(newOrder);
//        newUser.setBillingAddress(newAddress);
//        newUser.setAccountStatus( AccountStatus.USER);
//
//        Shoppingcart shoppingcart = new Shoppingcart();
//        newUser.setShoppingCart(shoppingcartRepository.save(shoppingcart));
//
//        String PasswordToHash = passwordEncoder.encode(newUser.getSecurePassword());
//        newUser.setSecurePassword(PasswordToHash);
//        userRepository.save(newUser);

        return "redirect:/order";

    }
}
