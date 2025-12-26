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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        user.setRole(User.ROLE_USER);
        return repo.save(user);
    }
}
