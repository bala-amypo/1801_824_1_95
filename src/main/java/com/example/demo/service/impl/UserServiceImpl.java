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


corect
package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.BadRequestException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

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

    @Override
    public User getByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() ->
                        new BadRequestException("User not found"));
    }
}


// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.security.JwtTokenProvider;

// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository repo;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtTokenProvider jwtTokenProvider;

//     public UserServiceImpl(UserRepository repo,
//                            PasswordEncoder passwordEncoder,
//                            JwtTokenProvider jwtTokenProvider) {
//         this.repo = repo;
//         this.passwordEncoder = passwordEncoder;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @Override
//     public User register(User user) {

//         if (repo.existsByEmail(user.getEmail())) {
//             throw new BadRequestException("Email already exists");
//         }

//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         user.setRole("ROLE_USER");
//         return repo.save(user);
//     }

//     @Override
//     public String login(String email, String password) {

//         User user = repo.findByEmail(email)
//                 .orElseThrow(() ->
//                         new BadRequestException("Invalid email or password"));

//         if (!passwordEncoder.matches(password, user.getPassword())) {
//             throw new BadRequestException("Invalid email or password");
//         }

//         // ✅ Generate JWT token
//         return jwtTokenProvider.generateToken(
//                 null,
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );
//     }
// }
