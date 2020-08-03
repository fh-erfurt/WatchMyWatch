package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.model.WatchManagment.Bracelet;
import de.watchmywatch.model.WatchManagment.Casing;
import de.watchmywatch.model.WatchManagment.Clockwork;
import de.watchmywatch.model.WatchManagment.Watch;
import de.watchmywatch.repository.storage.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class WatchConfigController {
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public ShoppingcartRepository shoppingcartRepository;
    @Autowired
    public WatchRepository watchRepository;
    @Autowired
    public BraceletRepository braceletRepository;
    @Autowired
    public CasingRepository casingRepository;
    @Autowired
    public ClockworkRepository clockworkRepository;


    @PostMapping(path = "/newWatch")
    public String addNewUser(@Valid @ModelAttribute("newWatch") Watch newWatch, BindingResult watchBindingResult,
                             @ModelAttribute("newBracelet") Bracelet bracelet, @ModelAttribute("newCasing") Casing casing,
                             @ModelAttribute("newClockwork") Clockwork clockwork) {

        if (watchBindingResult.hasErrors()) {
            return "/watchConfigurator";
        }

        Optional<Watch> watch = watchRepository.findByName(newWatch.getName());

        if (watch.isPresent()) {
            watchBindingResult.rejectValue("name", "error.newWatch", "A Watch with the same name already exists");
            return "/watchConfigurator";
        }

        Bracelet chosenBracelet = braceletRepository.findById(bracelet.getId()).get();
        Casing chosenCasing = casingRepository.findById(casing.getId()).get();
        Clockwork chosenClockwork = clockworkRepository.findById(clockwork.getId()).get();

        newWatch.setBracelet(chosenBracelet);
        newWatch.setCasing(chosenCasing);
        newWatch.setClockwork(chosenClockwork);

        if (newWatch.validate()) {
            watchRepository.save(newWatch);
        } else {
            logger.warning("Watch was not valid");
            return "redirect:/index";
        }
        return "redirect:/watchConfigurator";
    }
}
