package de.watchmywatch.repository.storage;

import de.watchmywatch.model.WatchManagment.Bracelet;
import de.watchmywatch.model.WatchManagment.Casing;
import de.watchmywatch.model.WatchManagment.Clockwork;
import de.watchmywatch.model.WatchManagment.Watch;
import de.watchmywatch.repository.storage.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String addNewUser(@Valid @ModelAttribute("watchDetails") WatchDetails watchDetails, BindingResult result) {

        if (result.hasErrors()) {
            if (watchDetails.getName() == "") {
                logger.warning("no watch name given");
            }
            if (watchDetails.getParticularity() == "") {
                logger.warning("no particularity given");
            }
            if (watchDetails.getBraceletId() == 0 || watchDetails.getCasingId() == 0 || watchDetails.getClockworkId() == 0) {
                logger.warning("one part was not picked");
            }
            return "/watchConfigurator";
        }


        Optional<Watch> watch = watchRepository.findByName(watchDetails.getName());

        if (watch.isPresent()) {
            result.rejectValue("name", "error.watchDetails", "A Watch with the same name already exists");
            return "redirect:/watchConfigurator";
        }

        Bracelet chosenBracelet = braceletRepository.findById(watchDetails.getBraceletId()).get();
        Casing chosenCasing = casingRepository.findById(watchDetails.getCasingId()).get();
        Clockwork chosenClockwork = clockworkRepository.findById(watchDetails.getClockworkId()).get();

        Watch newWatch = new Watch();

        newWatch.setName(watchDetails.getName());
        newWatch.setParticularity(watchDetails.getParticularity());
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
