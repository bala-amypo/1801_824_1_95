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

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/addcategory")
    public Category add(@RequestBody Category c) {
        return service.addCategory(c);
    }

    @GetMapping("/getall")
    public List<Category> getAll() {
        return service.getAll();
    }
}
