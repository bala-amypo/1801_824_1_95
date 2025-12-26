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

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    // ✅ REQUIRED constructor
    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Category addCategory(Category category) {

        if (repo.existsByName(category.getName())) {
            throw new RuntimeException("Category already exists");
        }

        // 🔥 test expects this call
        category.validateType();

        return repo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }
}
