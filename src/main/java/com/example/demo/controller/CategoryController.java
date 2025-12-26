// package com.example.demo.controller;
// import java.util.List;
// import com.example.demo.service.CategoryService;
// import com.example.demo.model.Category;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestMapping;
// @RestController
// @RequestMapping("/Category")
// public class CategoryController {
//     @Autowired
//     CategoryService cs;
//     @PostMapping("/addcategory")
//     public  Category create(@RequestBody Category cat){
//         return cs.addCategory(cat);
//     }
//     @GetMapping("/getall")
//     public List<Category> listall(){
//         return cs.getAllCategory();
//     }
    
// }
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/regiter")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return service.getByEmail(email);
    }
}
