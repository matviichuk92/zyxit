package zyxittask.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zyxittask.demo.model.User;
import zyxittask.demo.service.UserService;
import java.util.Optional;

@Service
public class CustomUserDetailsImpl implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByName(name);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            org.springframework.security.core.userdetails.User.UserBuilder userBuilder
                    = org.springframework.security.core.userdetails
                    .User.withUsername(user.getName());
            userBuilder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            userBuilder.roles(user.getRoles().stream().map(Enum::toString).toArray(String[]::new));
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException("User with " + name + "name not found");
        }
    }
}
