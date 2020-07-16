package de.watchmywatch.repository.storage;


import de.watchmywatch.model.AccountManagment.AccountStatus;
import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.repository.storage.api.AddressRepository;
import de.watchmywatch.repository.storage.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegisterController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;


    @PostMapping(path = "/newUser")
    public String addNewUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult userBindingResult,
                             @Valid @ModelAttribute("newAddress")  Address newAddress, BindingResult addressBindingResult) {

        if ( userBindingResult.hasErrors() || addressBindingResult.hasErrors()) {
            return "/register";
        }

        Optional<User> test = userRepository.findByEmail(newUser.getEmail());

        if(test.isPresent())
        {
            userBindingResult.rejectValue("email", "error.newUser","An account already exists for this email.");
            return "/register";
        }
            addressRepository.save(newAddress);
            newUser.setAddress(newAddress);
            newUser.setBillingAddress(newAddress);
            newUser.setRole("USER");

        String PasswordToHash = passwordEncoder.encode(newUser.getSecurePassword());
            newUser.setSecurePassword(PasswordToHash);
            userRepository.save(newUser);
            return "redirect:/index";

    }





}
