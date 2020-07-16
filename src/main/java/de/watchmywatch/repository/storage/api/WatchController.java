package de.watchmywatch.repository.storage.api;


import de.watchmywatch.model.WatchManagment.*;
import de.watchmywatch.repository.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class WatchController {
    @Autowired
    public WatchRepository watchRepository;
    @Autowired
    public BraceletRepository braceletRepository;
    @Autowired
    public CasingRepository casingRepository;
    @Autowired
    public ClockworkRepository clockworkRepository;
    @Autowired
    public ManufacturerRepository manufacturerRepository;


    /* -------------- WatchApi -------------- */
    // GET /api/watches returns all watches
    @GetMapping(path = "/watches", produces = "application/json")
    public @ResponseBody
    Iterable<Watch> getAllWatches() {
        return watchRepository.findAll();
    }

    // GET /api/watches/:id returns watch with id
    @GetMapping(path = "/watches/{id}", produces = "application/json")
    public @ResponseBody
    Watch getOneWatch(@PathVariable Integer id) {
        return watchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("watch", id));
    }

    // POST /api/watches creates a watch in the database and returns it
    @PostMapping(path = "/watches", produces = "application/json")
    public @ResponseBody
    Watch addNewWatch(@RequestParam String name, @RequestParam String particularity, @RequestParam int braceletId, @RequestParam int casingId, @RequestParam int clockworkId) {
        Optional<Bracelet> optionalBracelet = braceletRepository.findById(braceletId);
        Bracelet bracelet = optionalBracelet.get();
        Optional<Casing> optionalCasing = casingRepository.findById(casingId);
        Casing casing = optionalCasing.get();
        Optional<Clockwork> optionalClockwork = clockworkRepository.findById(clockworkId);
        Clockwork clockwork = optionalClockwork.get();

        Watch watch = new Watch(name, particularity, bracelet, casing, clockwork);

        return watchRepository.save(watch);
    }

    // PUT /api/watches updates the watch with the id
    @PutMapping(path = "/watches/{id}", produces = "application/json")
    public @ResponseBody
    Watch updateWatch(@PathVariable Integer id, @RequestParam String name, @RequestParam String particularity,
                      @RequestParam int braceletId, @RequestParam int casingId, @RequestParam int clockworkId) {
        return watchRepository.findById(id)
                .map(watch -> {
                    watch.setName(name);
                    watch.setParticularity(particularity);

                    Optional<Bracelet> optionalBracelet = braceletRepository.findById(braceletId);
                    watch.setBracelet(optionalBracelet.get());

                    Optional<Casing> optionalCasing = casingRepository.findById(casingId);
                    watch.setCasing(optionalCasing.get());

                    Optional<Clockwork> optionalClockwork = clockworkRepository.findById(clockworkId);
                    watch.setClockwork(optionalClockwork.get());

                    return watchRepository.save(watch);
                })
                .orElseGet(() -> {
                            Watch watch = new Watch(name, particularity);
                            Optional<Bracelet> optionalBracelet = braceletRepository.findById(braceletId);
                            watch.setBracelet(optionalBracelet.get());

                            Optional<Casing> optionalCasing = casingRepository.findById(casingId);
                            watch.setCasing(optionalCasing.get());

                            Optional<Clockwork> optionalClockwork = clockworkRepository.findById(clockworkId);
                            watch.setClockwork(optionalClockwork.get());

                            watch.setId(id);
                            return watchRepository.save(watch);
                        }
                );
    }

    // DELETE /api/watches/:id deletes the watch with id
    @DeleteMapping(path = "/watches/{id}", produces = "application/json")
    public @ResponseBody
    String deleteWatch(@PathVariable Integer id) {
        watchRepository.deleteById(id);
        return "Deleted";
    }

    /* -------------- Watchparts -------------- */

    /* -------------- BraceletApi -------------- */
    // GET /api/bracelets returns all bracelets
    @GetMapping(path = "/bracelets", produces = "application/json")
    public @ResponseBody
    Iterable<Bracelet> getAllBracelets() {
        return braceletRepository.findAll();
    }

    // GET /api/bracelets/:id returns bracelet with id
    @GetMapping(path = "/bracelets/{id}", produces = "application/json")
    public @ResponseBody
    Bracelet getOneBracelet(@PathVariable Integer id) {
        return braceletRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("bracelet", id));
    }

    // POST /api/bracelets creates a bracelet in the database and returns it
    @PostMapping(path = "/bracelets", produces = "application/json")
    public @ResponseBody
    Bracelet addNewBracelet(@RequestParam String name, @RequestParam Integer manufacturerId, @RequestParam Integer amountAvailable,
                            @RequestParam String manufacturerPartId, @RequestParam Material material,
                            @RequestParam double price, @RequestParam double size, @RequestParam ConnectionType connection) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(manufacturerId);
        Manufacturer manufacturer = optionalManufacturer.get();
        Bracelet bracelet = new Bracelet(name, manufacturer, manufacturerPartId, material, price, amountAvailable, size, connection);

        return braceletRepository.save(bracelet);
    }

    // PUT /api/bracelets/:id returns updated bracelet
    @PutMapping(path = "/bracelets/{id}", produces = "application/json")
    public @ResponseBody
    Bracelet updateBracelet(@PathVariable Integer id, @RequestParam Integer amountAvailable) {
        Optional<Bracelet> optionalBracelet = braceletRepository.findById(id);
        Bracelet bracelet = optionalBracelet.get();

        bracelet.setAmountAvailable(amountAvailable);

        return braceletRepository.save(bracelet);
    }

    // DELETE /api/bracelets/:id deletes the bracelet with id
    @DeleteMapping(path = "/bracelets/{id}", produces = "application/json")
    public @ResponseBody
    String deleteBracelet(@PathVariable Integer id) {
        braceletRepository.deleteById(id);
        return "Deleted";
    }

    /* -------------- CasingApi -------------- */
    // GET /api/casings returns all casings
    @GetMapping(path = "/casings", produces = "application/json")
    public @ResponseBody
    Iterable<Casing> getAllCasings() {
        return casingRepository.findAll();
    }

    // GET /api/casings/:id returns casing with id
    @GetMapping(path = "/casings/{id}", produces = "application/json")
    public @ResponseBody
    Casing getOneCasing(@PathVariable Integer id) {
        return casingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("casing", id));
    }

    // POST /api/casings creates a casing in the database and returns it
    @PostMapping(path = "/casings", produces = "application/json")
    public @ResponseBody
    Casing addNewCasing(@RequestParam String name, @RequestParam Integer manufacturerId, @RequestParam Integer amountAvailable,
                        @RequestParam String manufacturerPartId, @RequestParam Material material,
                        @RequestParam double price, @RequestParam double outerDiameter,
                        @RequestParam double innerDiameter, @RequestParam ConnectionType connection) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(manufacturerId);
        Manufacturer manufacturer = optionalManufacturer.get();
        Casing casing = new Casing(name, manufacturer, manufacturerPartId, material, price, amountAvailable, outerDiameter, innerDiameter, connection);

        return casingRepository.save(casing);
    }

    // PUT /api/casings/:id returns updated casing
    @PutMapping(path = "/casings/{id}", produces = "application/json")
    public @ResponseBody
    Casing updateCasing(@PathVariable Integer id, @RequestParam Integer amountAvailable) {
        Optional<Casing> optionalCasing = casingRepository.findById(id);
        Casing casing = optionalCasing.get();

        casing.setAmountAvailable(amountAvailable);

        return casingRepository.save(casing);
    }

    // DELETE /api/casings/:id deletes the casing with id
    @DeleteMapping(path = "/casings/{id}", produces = "application/json")
    public @ResponseBody
    String deleteCasing(@PathVariable Integer id) {
        casingRepository.deleteById(id);
        return "Deleted";
    }

    /* -------------- ClockworkApi -------------- */
    // GET /api/clockworks returns all clockworks
    @GetMapping(path = "/clockworks", produces = "application/json")
    public @ResponseBody
    Iterable<Clockwork> getAllClockworks() {
        return clockworkRepository.findAll();
    }

    // GET /api/clockworks/:id returns clockwork with id
    @GetMapping(path = "/clockworks/{id}", produces = "application/json")
    public @ResponseBody
    Clockwork getOneClockwork(@PathVariable Integer id) {
        return clockworkRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("clockwork", id));
    }

    // POST /api/clockworks creates a clockwork in the database and returns it
    @PostMapping(path = "/clockworks", produces = "application/json")
    public @ResponseBody
    Clockwork addNewClockwork(@RequestParam String name, @RequestParam Integer manufacturerId, @RequestParam Integer amountAvailable,
                              @RequestParam String manufacturerPartId, @RequestParam Material material,
                              @RequestParam double price, @RequestParam double diameter) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(manufacturerId);
        Manufacturer manufacturer = optionalManufacturer.get();
        Clockwork clockwork = new Clockwork(name, manufacturer, manufacturerPartId, material, price, amountAvailable, diameter);

        return clockworkRepository.save(clockwork);
    }

    // PUT /api/clockworks/:id returns updated clockwork
    @PutMapping(path = "/clockworks/{id}", produces = "application/json")
    public @ResponseBody
    Clockwork updateClockwork(@PathVariable Integer id, @RequestParam Integer amountAvailable) {
        Optional<Clockwork> optionalClockwork = clockworkRepository.findById(id);
        Clockwork clockwork = optionalClockwork.get();

        clockwork.setAmountAvailable(amountAvailable);

        return clockworkRepository.save(clockwork);
    }

    // DELETE /api/clockworks/:id deletes the clockwork with id
    @DeleteMapping(path = "/clockworks/{id}", produces = "application/json")
    public @ResponseBody
    String deleteClockwork(@PathVariable Integer id) {
        clockworkRepository.deleteById(id);
        return "Deleted";
    }
}