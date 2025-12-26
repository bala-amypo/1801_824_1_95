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

import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User register(User user) {
        return repo.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return repo.findByEmail(email).orElseThrow();
    }
}
