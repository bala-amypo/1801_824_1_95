package com.example.demo.service;
 import java.util.List;
import com.example.demo.model.Category;
 
public interface CategoryService {
    public Category addCategory(Category category);
    public List<Category>getAllCategories();
}