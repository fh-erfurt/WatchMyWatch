package de.watchmywatch.repository.storage;


import de.watchmywatch.model.AccountManagment.AccountStatus;
import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.model.Helper.Address;
import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.repository.storage.api.AddressRepository;
import de.watchmywatch.repository.storage.api.ShoppingcartRepository;
import de.watchmywatch.repository.storage.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UpdateUserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    public ShoppingcartRepository shoppingcartRepository;


    @PostMapping(path = "/updateUser")
    public String updateUser(@Valid @ModelAttribute("updateUser") User updateUser, BindingResult updateUserBindingResult,
                             @Valid @ModelAttribute("updateAddress")  Address updateAddress, BindingResult updateAddressBindingResult,
                             Authentication authentication) {


        if ( updateUserBindingResult.hasErrors() || updateAddressBindingResult.hasErrors()) {
            return "/updateUser";
        }

        Optional<User> optionalUser = userRepository.findByEmail(updateUser.getEmail());
        User user = optionalUser.get();



        if(user.getAddress().getCity() == updateAddress.getCity()
                && user.getAddress().getState() == updateAddress.getState()
                && user.getAddress().getZip() == updateAddress.getZip()
                && user.getAddress().getStreet() == updateAddress.getStreet())
        {
            // DO NOTHING
        }
        else{
            Address saveAddress = addressRepository.save(updateAddress);
            user.setAddress(saveAddress);
            user.setBillingAddress(saveAddress);
        }
        user.setDob(updateUser.getDob());
        user.setEmail(updateUser.getEmail());
        user.setFirstname(updateUser.getFirstname());
        user.setLastname(updateUser.getLastname());
        user.setPhone(updateUser.getPhone());
        user.setAccountStatus( AccountStatus.USER);

        userRepository.save(user);


        return "redirect:/index";

    }
}
