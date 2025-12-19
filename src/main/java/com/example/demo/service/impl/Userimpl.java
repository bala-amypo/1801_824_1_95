package com.example.demo.service;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
public class Userimpl implements UserService{
    @Autowired
    UserRepository ur;
    public User register(User user){
     return  ur.save(user);
    }

    
    public User findByEmails(String email){
     return ur.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
    }
    
}