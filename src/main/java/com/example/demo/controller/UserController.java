package com.example.demo.controller;
import java.util.List;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
    @Autowired
    UserService us;
    @PostMapping("/postre")
    public  User registercon(@RequestBody User user){
        return us.register(user);
    }
    
}