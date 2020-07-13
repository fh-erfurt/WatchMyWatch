package de.watchmywatch.repository.storage;

import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.WatchManagment.*;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class WatchController {
    @Autowired
    public WatchRepository watchRepository;

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
    Watch addNewWatch(@RequestBody Watch watch)
    {
        //customer find all email = email
        return watchRepository.save(watch);
    }

    // PUT /api/watches updates the watch with the id
    @PutMapping(path = "/watches/{id}", produces = "application/json")
    public @ResponseBody
    Watch updateWatch(@PathVariable Integer id, @RequestBody Watch newWatch) {
        return watchRepository.findById(id)
                .map(watch -> {
                    try {
                        watch.setName(newWatch.getName());
                    } catch (WatchNameNotValidException e) {
                        e.printStackTrace();
                    }
                    watch.setParticularity(newWatch.getParticularity());
                    return watchRepository.save(watch);
                })
                .orElseGet(() -> {
                    newWatch.setId(id);
                    return watchRepository.save(newWatch);
                });
    }

    // DELETE /api/watches/:id deletes the watch with id
    @DeleteMapping(path = "/watches/{id}", produces = "application/json")
    public @ResponseBody
    String updateWatch(@PathVariable Integer id) {
        watchRepository.deleteById(id);
        return "Deleted";
    }
}