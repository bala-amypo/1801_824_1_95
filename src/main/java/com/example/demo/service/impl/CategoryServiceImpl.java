// package com.example.demo.service;
//  import java.util.List;
// import com.example.demo.model.Category;
//  import com.example.demo.repository.CategoryRepository;
//  import org.springframework.beans.factory.annotation.Autowired;
//  import com.example.demo.service.CategoryService;
//  import org.springframework.stereotype.Service;
//  @Service
// public class Categoryimpl implements CategoryService {
//     @Autowired
//     CategoryRepository cr;
//     public Category addCategory(Category category){
//       return cr.save(category);
//     }
//     public List<Category>getAllCategory(){
//       return cr.findAll();
//     }

// }


package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category addCategory(Category category) {
        return repo.save(category);
    }

    public List<Category> getAll() {
        return repo.findAll();
    }
}
