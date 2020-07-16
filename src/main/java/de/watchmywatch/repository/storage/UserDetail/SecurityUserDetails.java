package de.watchmywatch.repository.storage.UserDetail;

import de.watchmywatch.model.AccountManagment.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityUserDetails implements UserDetails {

    private String email;
    private String password;
    private List<GrantedAuthority> authorities;

    public SecurityUserDetails(User user) {

        this.email = user.getEmail();
        this.password = user.getSecurePassword();
        this.authorities = Arrays.stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {return email;}

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {return true;}

}

