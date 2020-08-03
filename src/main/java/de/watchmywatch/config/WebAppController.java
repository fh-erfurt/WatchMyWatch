package de.watchmywatch.config;

import de.watchmywatch.model.AccountManagment.*;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.*;
import de.watchmywatch.model.WatchManagment.*;
import de.watchmywatch.repository.storage.UserDetail.SecurityUserDetails;
import de.watchmywatch.repository.storage.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class WebAppController {
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private String appMode;
    @Autowired
    WatchRepository watchRepository;
    @Autowired
    BraceletRepository braceletRepository;
    @Autowired
    CasingRepository casingRepository;
    @Autowired
    ClockworkRepository clockworkRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShoppingcartRepository shoppingcartRepository;
    @Autowired
    OrderRepository orderRepository;

    public WebAppController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Tom");
        model.addAttribute("mode", appMode);
        model.addAttribute("title", "Homepage");

        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    private static List<Watch> watches = new ArrayList<Watch>();
    @GetMapping("/watchList")
    public String watchList(Model model) {
        model.addAttribute("title", "Watch-List");
        model.addAttribute("watches", watches);
        watches.clear();
        Iterable<Watch> allWatches = watchRepository.findAll();
        for (Watch watch: allWatches) {
            watches.add(watch);
        }

        return "watchList";
    }

    @GetMapping("/watchConfigurator")
    public String watchConfigurator(Model model) {
        model.addAttribute("title", "Watch-Configurator");
        Iterable<Bracelet> bracelets = braceletRepository.findAll();
        Iterable<Casing> casings = casingRepository.findAll();
        Iterable<Clockwork> clockworks = clockworkRepository.findAll();

        model.addAttribute("bracelets", bracelets);
        model.addAttribute("casings", casings);
        model.addAttribute("clockworks", clockworks);

        model.addAttribute("newBracelet", new Bracelet());
        model.addAttribute("newCasing", new Casing());
        model.addAttribute("newClockwork", new Clockwork());

        model.addAttribute("newWatch", new Watch());
        return "watchConfigurator";
    }



    @GetMapping("/register")
    public String newUser(Model model) {
        model.addAttribute("newAddress", new Address());
        model.addAttribute("newUser", new User());

        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping(value = "/loginSuccessfull")
    public String currentUserName(Authentication authentication) {
        return "redirect:/";
    }

    @GetMapping("/shoppingcart")
    public String shoppingcart(Authentication authentication, Model model) {
        // TODO: getUserByAuthentication als Funktion auslagern
        List<Watch> items = new ArrayList<Watch>();
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);

        if(user.isPresent()) {
            model.addAttribute("title", "Shoppingcart");
            Shoppingcart shoppingcart1 = user.get().getShoppingCart();
            shoppingcart1.calcTotal();      // TODO: Remove when DB is consistent/clear and filled by API's
            model.addAttribute("shoppingcart1", shoppingcart1);
            model.addAttribute("shippingFee", Order.SHIPPINGFEE);
            model.addAttribute("items", shoppingcart1.getItems());
            model.addAttribute("removeWatchId", null);
        }
        else{
            return "redirect:/";
        }
        return "shoppingcart";
    }

    @GetMapping("/checkout")
    public String checkout(Authentication authentication, Model model) throws ShoppingcartEmptyException {
        // TODO: getUserByAuthentication als Funktion auslagern
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        if(user.isPresent()) {
            model.addAttribute("title", "Checkout");
            if(!user.get().getShoppingCart().getItems().isEmpty())
            {
                model.addAttribute("userId" , user.get().getId());
                Address address = user.get().getAddress();
                model.addAttribute("address", address );

                Shoppingcart shoppingcart = user.get().getShoppingCart();
                shoppingcart.calcTotal();      // TODO: Remove when DB is consistent/clear and filled by API's
                model.addAttribute("total"  ,shoppingcart.getTotal() + Order.SHIPPINGFEE);
                model.addAttribute("paymentMethods", new String[]{
                        PaymentMethod.PAYPAL.toString() ,    PaymentMethod.CREDITCARD.toString() ,
                        PaymentMethod.SEPA.toString()   ,    PaymentMethod.TRANSFER.toString()   });

                Payment newPayment = new Payment();
//                String prefPaymentMethod = "";
                if (user.get().getPaymentMethod() != null)
                {
//                    prefPaymentMethod = user.get().getPaymentMethod().toString();
                    newPayment.setPaymentMethod(user.get().getPaymentMethod());
                }
//                model.addAttribute("prefPaymentMethod", prefPaymentMethod);
                model.addAttribute("newPayment", newPayment);

            }
            else
            {
                return "redirect:/";
            }
        }
        else{
            return "redirect:/";
        }
        return "checkout";
    }

    @GetMapping("/order")
    public String order(Authentication authentication, Model model) {
        // TODO: getUserByAuthentication als Funktion auslagern
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        model.addAttribute("title", "Order");
        if(!user.isPresent()) {
            return "redirect:/";
        }
        return "order";
    }
    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        model.addAttribute("title", "Your Profile");
        String userEmail = authentication.getName();
        Optional<User> user = userRepository.findByEmail(userEmail);
        if(user.isPresent()) {
            model.addAttribute("firstName", user.get().getFirstname());
            model.addAttribute("lastName", user.get().getLastname());
            model.addAttribute("email", user.get().getEmail());
            model.addAttribute("dob", user.get().getDob());
            model.addAttribute("street", user.get().getAddress().getStreet());
            model.addAttribute("zip", user.get().getAddress().getZip());
            model.addAttribute("state", user.get().getAddress().getState());
            model.addAttribute("city", user.get().getAddress().getCity());
        }
        else{
            return "redirect:/";
        }
        return "profile";
    }

    @GetMapping("/updateUser")
    public String updateUser(Model model) {
        model.addAttribute("title", "Update User");
        model.addAttribute("updateAddress", new Address());
        model.addAttribute("updateUser", new User());

        return "updateUser";
    }
}