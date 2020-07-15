package de.watchmywatch.repository.storage;


import de.watchmywatch.model.AccountManagment.Customer;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.repository.storage.api.AddressRepository;
import de.watchmywatch.repository.storage.api.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public AddressRepository addressRepository;


    @PostMapping(path = "/newCustomer")
    public String addNewCustomer(@Valid @ModelAttribute("newCustomer") Customer newCustomer, BindingResult customerBindingResult,
                                @Valid @ModelAttribute("newAddress")  Address newAddress, BindingResult addressBindingResult) {



        if ( customerBindingResult.hasErrors() || addressBindingResult.hasErrors()) {
            return "/register";
        } else {

            addressRepository.save(newAddress);
            newCustomer.setAddress(newAddress);
            customerRepository.save(newCustomer);

        return "redirect:/index";
        }
       // return "index";


    }

}
