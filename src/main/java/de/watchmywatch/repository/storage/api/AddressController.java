package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.Helper.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class AddressController {
    @Autowired
    public AddressRepository addressRepository;

    // GET /api/addresses returns all addresses
    @GetMapping(path = "/addresses")
    public @ResponseBody
    Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // GET /api/addresses/:id returns the address with the given id
    @GetMapping(value = "/addresses/{id}")
    public @ResponseBody
    Optional<Address> getOneAddress(@PathVariable Integer id) {
        return addressRepository.findById(id);
    }

    // POST /api/addresses creates the address with the send json-body
    @PostMapping(path = "/addresses", produces = "application/json")
    public @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    Address addNewAddress(@RequestBody Address address) {
        address.setCreated(new Date());
        address.setModified(null);
        return addressRepository.save(address);
    }

    // PUT /api/addresses/:id updates the address with the given id
    @PutMapping(value = "/addresses/{id}", produces = "application/json")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Address updateOneAddress(@RequestBody Address newAddress, @PathVariable Integer id) {
        return addressRepository.findById(id)
                .map(address -> {
                    address.setCity(newAddress.getCity());
                    address.setState(newAddress.getState());
                    address.setStreet(newAddress.getStreet());
                    address.setZip(newAddress.getZip());
                    address.setModified(new Date());
                    return addressRepository.save(address);
                })
                .orElseGet(() -> {
                    newAddress.setId(id);
                    return addressRepository.save(newAddress);
                });
    }

    // DELETE /api/addresses/:id deletes the address with the given id
    @DeleteMapping(value = "/addresses/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAddress(@PathVariable Integer id) {
        addressRepository.deleteById(id);
    }
}