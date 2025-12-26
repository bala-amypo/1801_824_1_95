// package com.example.demo.service;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.model.User;
// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import java.util.List;
// //import lombok.RequiredArgsConstructor;

// @Service
// // @RequiredArgsConstructor
// public class Userimpl implements UserService{
//     @Autowired
//     UserRepository ur;
//     public User register(User user){
//      return  ur.save(user);
//     }

    
//     public User findByEmails(String email){
//      return ur.findByEmail(email).orElse(null);
//     }
    
// }
package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.exception.BadRequestException;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    // ✅ REQUIRED CONSTRUCTOR (tests use it)
    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        if (repo.existsByEmail(user.getEmail())) {
    throw new BadRequestException("Email already exists");
}
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        return repo.save(user);
    }

    // ✅ MUST match interface exactly
    @Override
    public User getByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
}
