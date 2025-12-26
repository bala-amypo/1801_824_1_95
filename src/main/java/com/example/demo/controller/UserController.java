// package com.example.demo.controller;
// import java.util.List;
// import com.example.demo.service.UserService;
// import com.example.demo.model.User;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
// @RequestMapping("/User")
// public class UserController {
//     @Autowired
//     UserService us;
//     @PostMapping("/regiter")
//     public  User registercon(@RequestBody User user){
//         return us.register(user);
//     }
//     @GetMapping("/{email}")
//     public User getEmail(@PathVariable String email){
//         return us.findByEmails(email);
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

