package de.watchmywatch.repository.storage;

import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Exceptions.ShoppingcartEmptyException;
import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /demo (after Application path)

public class WatchController {
    @Autowired // This means to get the bean called CustomerRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    public WatchRepository watchRepository;

    //define helper findByIDs
    public Optional<Bracelet> findBraceletById(Long id) {
        return watchRepository.findBraceletById(id);
    }

    public Optional<Casing> findCasingById(Long id) {
        return watchRepository.findCasingById(id);
    }

    public Optional<Clockwork> findClockworkById(Long id) {
        return watchRepository.findClockworkById(id);
    }

    // GET /api/watches returns all watches
    @GetMapping(path = "/watches")
    public @ResponseBody
    Iterable<Watch> getAllWatches() {
        return watchRepository.findAll();
    }

    // GET /api/watches/:id returns watch with id
    @GetMapping(value = "/watches/{watchId}")
    public @ResponseBody
    Optional<Watch> getOneCustomer(@PathVariable Integer watchId) {
        return watchRepository.findById(watchId);
    }

    // POST /api/watches adds a watch to db
    @PostMapping(path = "/watches")
    public @ResponseBody
    String addNewWatch(@RequestParam String name, @RequestParam String particularity
            /*, @RequestParam long bracelet_id, @RequestParam long casing_id, @RequestParam long clockwork_id*/) throws ShoppingcartEmptyException, WatchNameNotValidException {
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", address,
                "01716181447", "Anton", "Bespalov", new Date(1998, Calendar.SEPTEMBER, 23)), address);
        Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 10000, 1, ConnectionType.BAND);
        Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 15000, 2, 2, ConnectionType.BAND);
        Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 25000, 2);

        Watch watch = new Watch(name, particularity, bracelet, casing, clockwork);

        watchRepository.save(watch);
        return "Saved";
    }

    @PutMapping(path = "/watches/{watchId}")
    public @ResponseBody
    String updateWatch(@PathVariable Integer watchId,@RequestParam String name, @RequestParam String particularity
            /*, @RequestParam long bracelet_id, @RequestParam long casing_id, @RequestParam long clockwork_id*/) throws ShoppingcartEmptyException, WatchNameNotValidException {
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        Manufacturer manufacturer = new Manufacturer("Apple", new Customer("anton.bespalov@fh-erfurt.de", address,
                "01716181447", "Anton", "Bespalov", new Date(1998, Calendar.SEPTEMBER, 23)), address);
        Bracelet bracelet = new Bracelet(manufacturer, "part1", Material.ALUMINIUM, 10000, 1, ConnectionType.BAND);
        Casing casing = new Casing(manufacturer, "part2", Material.ALUMINIUM, 15000, 2, 2, ConnectionType.BAND);
        Clockwork clockwork = new Clockwork(manufacturer, "part3", Material.ALUMINIUM, 25000, 2);

        Watch watch = new Watch(name, particularity, bracelet, casing, clockwork);

        watchRepository.save(watch);
        return "Updated";
    }

    @DeleteMapping(path = "/watches/{watchId}")
    public @ResponseBody
    String updateWatch(@PathVariable Integer watchId) {
        watchRepository.deleteById(watchId);
        return "Deleted";
    }


}



