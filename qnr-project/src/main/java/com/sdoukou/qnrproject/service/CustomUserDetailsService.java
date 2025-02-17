package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.User;
import com.sdoukou.qnrproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database, return Optional<User>
        Optional<User> optionalUser = userRepository.findByUsername(username);

        // Check if the user is present, if not, throw exception
        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return the user with the plain-text password
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),  // No encoding needed; using plain text password as stored
                new ArrayList<>() // No roles/authorities needed if you aren't using them
        );
    }

    // Add a method to fetch the User entity
    public User findByUsernameEntity(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
