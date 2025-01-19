package ma.xproce.servicesecurity.services;

import ma.xproce.servicesecurity.models.User;
import ma.xproce.servicesecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Assume you have a UserRepository to fetch users from DB

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); // Fetch user by username from DB
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // Return a UserDetails object
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList() // No authorities since roles are not used
        );
        }
}
