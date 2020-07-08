package de.watchmywatch.repository.storage;

import de.watchmywatch.model.Exceptions.WatchNameNotValidException;
import de.watchmywatch.model.WatchManagment.Manufacturer;
import de.watchmywatch.model.WatchManagment.Watch;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /api
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    // GET /api/manufacturers returns all manufacturers
    @GetMapping("/manufacturers")
    public @ResponseBody
    Iterable<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    // GET /api/manufacturers/:id returns manufacturer with id
    @GetMapping("/manufacturers/{id}")
    public @ResponseBody
    Manufacturer getOneManufacturer(@PathVariable Integer id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("manufacturer", id));
    }

    // POST /api/manufacturers creates a manufacturer
    @PostMapping("/manufacturers")
    public @ResponseBody
    Manufacturer newManufacturer(@RequestBody Manufacturer newManufacturer) {
        return manufacturerRepository.save(newManufacturer);
    }

    // PUT /api/manufacturers updates a manufacturer with id
    @PutMapping("/manufacturers/{id}")
    public @ResponseBody
    Manufacturer updateManufacturer(@PathVariable Integer id, @RequestBody Manufacturer newManufacturer) {
        return manufacturerRepository.findById(id)
                .map(manufacturer -> {
                    manufacturer.setName(newManufacturer.getName());
                    manufacturer.setContactPerson(newManufacturer.getContactPerson());
                    manufacturer.setAddress(newManufacturer.getAddress());
                    return manufacturerRepository.save(manufacturer);
                })
                .orElseGet(() -> {
                    newManufacturer.setId(id);
                    return manufacturerRepository.save(newManufacturer);
                });
    }

    // DELETE /api/manufacturers/:id deletes the manufacturer with id
    @DeleteMapping("/manufacturers/{id}")
    public @ResponseBody
    String deleteManufacturer(@PathVariable int id) {
        manufacturerRepository.deleteById(id);
        return "Deleted";
    }
}
