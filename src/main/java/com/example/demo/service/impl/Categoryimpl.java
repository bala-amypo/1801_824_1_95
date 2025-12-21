package com.example.demo.service;
 import java.util.List;
import com.example.demo.model.Category;
 import com.example.demo.repository.CategoryRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import com.example.demo.service.CategoryService;
 @Service
public class Categoryimpl implements CategoryService {
    @Autowired
    CategoryRepository cr;
    public Category addCategory(Category category){
      return cr.save(category);
    }
    public List<Category>getAllCategories(){
      return cr.getAll().orElseThrow(()->new RuntimeException("User not found"));
    }

}