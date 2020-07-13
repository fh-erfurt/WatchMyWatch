package de.watchmywatch.repository.storage;

import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.WatchManagment.Bracelet;
import de.watchmywatch.model.WatchManagment.Casing;
import de.watchmywatch.model.WatchManagment.Clockwork;
import de.watchmywatch.model.WatchManagment.Watch;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class WatchpartController {
    /* -------------- BraceletApi -------------- */
    @Autowired
    public BraceletRepository braceletRepository;

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
    Bracelet addNewBracelet(@RequestBody Bracelet bracelet) {
        return braceletRepository.save(bracelet);
    }

    /* -------------- CasingApi -------------- */
    @Autowired
    public CasingRepository casingRepository;

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
    Casing addNewCasing(@RequestBody Casing casing)
    {
        return casingRepository.save(casing);
    }

    /* -------------- ClockworkApi -------------- */
    @Autowired
    public ClockworkRepository clockworkRepository;

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
    Clockwork addNewClockwork(@RequestBody Clockwork clockwork) {
        return clockworkRepository.save(clockwork);
    }
}
