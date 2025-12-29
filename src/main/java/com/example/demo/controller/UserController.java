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
// package com.example.demo.controller;

// /* ===== REQUIRED SPRING IMPORTS ===== */
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

// /* ===== PROJECT IMPORTS ===== */
// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/user")
// public class UserController {

//     private final UserService service;

//     public UserController(UserService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return service.register(user);
//     }

//     @GetMapping("/{email}")
//     public User getByEmail(@PathVariable String email) {
//         return service.getByEmail(email);
//     }
// }


package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.AuthResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // Constructor injection (BEST PRACTICE)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // -------------------------------------------------
    // REGISTER USER (NO TOKEN GENERATED HERE)
    // -------------------------------------------------
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // -------------------------------------------------
    // LOGIN USER (TOKEN GENERATED HERE)
    // -------------------------------------------------
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        String token = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        return new AuthResponse(token);
    }
}
