package de.watchmywatch.repository.storage;


import de.watchmywatch.model.Helper.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /demo (after Application path)

public class AddressController {
    @Autowired // This means to get the bean called CustomerRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    public AddressRepository addressRepository;



    @PostMapping(path = "/address") // Map ONLY POST Requests
    public @ResponseBody
    String addNewAddress(Address addres) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        // TODO: Testing should be done in a different file/class ...
        Address address = new Address("Lilo-Herrmann-Straße 2", "Erfurt", "Thüringen", "99086");
        addressRepository.save(address);
        return "Saved";
    }

    @GetMapping(path="/addresses")
    public @ResponseBody Iterable<Address> getAllAddresses() {
        // This returns a JSON or XML with the users
        return addressRepository.findAll();
    }

    @GetMapping(value="/address/{addressId}")
    public @ResponseBody
    Optional<Address> getOneAddress(@PathVariable Integer addressId) {
        // This returns a JSON or XML with the one user

        return addressRepository.findById(addressId);
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }


}
