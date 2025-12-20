package com.example.demo.controller;
import java.util.List;
import com.example.demo.CategoryService;
import com.example.demo.model.Category;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
    @Autowired
    CategoryService cs;
    @PostMapping("/")
    public  User (@RequestBody User user){
        return cs.register(user);
    }
    @GetMapping("/{}")
    public User (@PathVariable String email){
        return cs.findByEmails(email);
    }
    
}