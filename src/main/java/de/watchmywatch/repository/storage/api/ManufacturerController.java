package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.WatchManagment.Manufacturer;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
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
    @ResponseStatus(HttpStatus.OK)
    Iterable<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    // GET /api/manufacturers/:id returns manufacturer with id
    @GetMapping("/manufacturers/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Manufacturer getOneManufacturer(@PathVariable Integer id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("manufacturer", id));
    }

    // POST /api/manufacturers creates a manufacturer
    @PostMapping("/manufacturers")
    public @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    Manufacturer newManufacturer(@RequestParam String name, @RequestParam int addressId, @RequestParam String contactEmail, @RequestParam String contactPhone) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        Address address = optionalAddress.get();

        Manufacturer manufacturer = new Manufacturer(name, contactEmail, contactPhone, address);

        return manufacturerRepository.save(manufacturer);
    }

    // PUT /api/manufacturers updates a manufacturer with id
    @PutMapping("/manufacturers/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Manufacturer updateManufacturer(@PathVariable Integer id, @RequestBody Manufacturer newManufacturer) {
        return manufacturerRepository.findById(id)
                .map(manufacturer -> {
                    manufacturer.setName(newManufacturer.getName());
                    manufacturer.setContactEmail(newManufacturer.getContactEmail());
                    manufacturer.setContactPhone(newManufacturer.getContactPhone());

                    Address newAddress = addressRepository.save(newManufacturer.getAddress());
                    manufacturer.setAddress(newAddress);
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteManufacturer(@PathVariable int id) {
        manufacturerRepository.deleteById(id);
    }
}
