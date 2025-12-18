package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.User;
@Service 
public interface UserService{
    public User register(User user);

    
    public User findByEmail(String email);
    
}