package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        // Dummy user for testing (JWT tests don’t validate DB here)
        return User.builder()
                .username(email)
                .password("password")
                .roles("USER")
                .build();
    }
}
