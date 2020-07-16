package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.Manufacturer;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /api
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

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
    Manufacturer newManufacturer(@RequestParam String name, @RequestParam int addressId,@RequestParam String contactEmail, @RequestParam String contactPhone) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        Address address = optionalAddress.get();


        Manufacturer manufacturer = new Manufacturer(name,contactEmail,contactPhone ,address);

        return manufacturerRepository.save(manufacturer);
    }

    // PUT /api/manufacturers updates a manufacturer with id
    @PutMapping("/manufacturers/{id}")
    public @ResponseBody
    Manufacturer updateManufacturer(@PathVariable Integer id, @RequestBody Manufacturer newManufacturer) {
        return manufacturerRepository.findById(id)
                .map(manufacturer -> {
                    manufacturer.setName(newManufacturer.getName());
                    manufacturer.setContactEmail(newManufacturer.getContactEmail());
                    manufacturer.setContactPhone(newManufacturer.getContactPhone());
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
