package com.iba.security.service;

import com.iba.security.entity.User;
import com.iba.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.error("Exception occurred when getting " + email);
                    return new UsernameNotFoundException("user with " + email + " email is not found");
                });

        log.info("User with email " + email + "was issued");

        return createUserDetailsInstance(user);
    }

    private UserDetails createUserDetailsInstance(final User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getIsUserNonLocked(),
                true,
                true,
                true,
                Set.of(new SimpleGrantedAuthority(user.getRole().getName()))
        );
    }

}
