package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return User.builder()
                .username(username)
                .password("password")
                .roles("USER")
                .build();
    }
}
