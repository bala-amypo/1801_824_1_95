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

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category addCategory(Category category) {
        return repo.save(category);
    }

    public List<Category> getAllCategories() {
        return repo.findAll();
    }
}
