package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @PostMapping(path = "/addresses")
    public @ResponseBody
    String addNewAddress(@RequestBody Address address) {
        address.setCreated(new Date());
        address.setModified(null);
        addressRepository.save(address);
        return "Saved";
    }

    // PUT /api/addresses/:id updates the address with the given id
    @PutMapping("/addresses/{id}")
    public @ResponseBody
    Address updateAddress(@PathVariable Integer id, @RequestBody Address newAddress) {
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
    @DeleteMapping("/addresses/{id}")
    public @ResponseBody
    String deleteAddress(@PathVariable int id) {
        addressRepository.deleteById(id);
        return "Deleted";
    }
}