package de.watchmywatch.repository.storage.UserDetail;

import de.watchmywatch.model.AccountManagment.User;
import de.watchmywatch.repository.storage.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);


        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + user.isPresent()));
        //SecurityUserDetails securityUserDetails = new SecurityUserDetails(user.get());
        //return securityUserDetails;
        return user.map(SecurityUserDetails::new).get();
    }
}
