package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.Category;
public interface CategoryService {
    public Category addCategory(Category category);
    public List<Category>getAllCategories();
}