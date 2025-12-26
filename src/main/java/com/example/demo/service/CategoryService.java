// package com.example.demo.service;
//  import java.util.List;
// import com.example.demo.model.Category;
 
// public interface CategoryService {
//     public Category addCategory(Category cat);
//     public List<Category>getAllCategory();
// }

package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);

    // 🔥 EXACT name expected by tests
    List<Category> getAllCategories();
}
