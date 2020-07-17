package de.watchmywatch.config;

import de.watchmywatch.model.AccountManagment.*;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import de.watchmywatch.repository.storage.api.BraceletRepository;
import de.watchmywatch.repository.storage.api.CasingRepository;
import de.watchmywatch.repository.storage.api.ClockworkRepository;
import de.watchmywatch.repository.storage.api.WatchRepository;
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

@Controller
public class WebAppController {
    private String appMode;
    @Autowired
    WatchRepository watchRepository;
    @Autowired
    BraceletRepository braceletRepository;
    @Autowired
    CasingRepository casingRepository;
    @Autowired
    ClockworkRepository clockworkRepository;


    public WebAppController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Tom");
        model.addAttribute("mode", appMode);

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
        Iterable<Bracelet> bracelets = braceletRepository.findAll();
        Iterable<Casing> casings = casingRepository.findAll();
        Iterable<Clockwork> clockworks = clockworkRepository.findAll();

        model.addAttribute("bracelets", bracelets);
        model.addAttribute("casings", casings);
        model.addAttribute("clockworks", clockworks);

        return "watchConfigurator";
    }



    @GetMapping("/register")
    public String newUser(Model model) {
        model.addAttribute("newAddress", new Address());
        model.addAttribute("newUser", new User());

        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/loginSuccessfull")
    public String currentUserName(Authentication authentication) {
        return "redirect:/";
    }



}