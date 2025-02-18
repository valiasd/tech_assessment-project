package com.sdoukou.qnrproject.authentication;

import com.sdoukou.qnrproject.model.User; // Your custom User class
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private final User user; // Your custom User class

    public CustomUserDetails(User user) {
        this.user = user; // Store the actual user object
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming no roles for now, return an empty list
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // Return password from your custom User object
    }

    @Override
    public String getUsername() {
        return user.getUsername(); // Return username from your custom User object
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming the account is non-expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming the account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming the account is enabled
    }

    public User getUser() {
        return user; // Return the custom User object
    }
}
